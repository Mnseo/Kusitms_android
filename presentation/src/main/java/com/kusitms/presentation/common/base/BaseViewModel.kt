package com.kusitms.presentation.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : ViewState, A : ViewSideEffect, E : ViewEvent>(
    initialState: S
) : ViewModel() {
    abstract fun handleEvents(event: E)

    private val _viewState: MutableStateFlow<S> = MutableStateFlow<S>(initialState)
    val viewState = _viewState.asStateFlow()

    private val currentState: S
        get() = _viewState.value

    private val _effect: Channel<A> = Channel()
    val effect = _effect.receiveAsFlow()

    private val _event: MutableSharedFlow<E> = MutableSharedFlow()

    protected fun updateState(reducer: S.() -> S) {
        val newState = currentState.reducer()
        _viewState.value = newState
    }

    protected fun sendEffect(vararg builder: () -> A) {
        for (effectValue in builder) {
            viewModelScope.launch { _effect.send(effectValue()) }
        }
    }

    open fun setEvent(event: E) {
        sendEvent(event)
    }

    private fun sendEvent(event: E) = viewModelScope.launch {
        handleEvents(event)
    }
}