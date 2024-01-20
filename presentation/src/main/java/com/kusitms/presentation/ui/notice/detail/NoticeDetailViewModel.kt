package com.kusitms.presentation.ui.notice.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.notice.CommentContentModel
import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.ReportCommentContentModel
import com.kusitms.domain.model.report.ReportResult
import com.kusitms.domain.usecase.notice.AddNoticeChildCommentUseCase
import com.kusitms.domain.usecase.notice.AddNoticeCommentUseCase
import com.kusitms.domain.usecase.notice.DeleteCommentUseCase
import com.kusitms.domain.usecase.notice.GetChildCommentListUseCase
import com.kusitms.domain.usecase.notice.GetNoticeCommentListUseCase
import com.kusitms.domain.usecase.notice.GetNoticeDetailUseCase
import com.kusitms.domain.usecase.report.ReportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getNoticeDetailUseCase: GetNoticeDetailUseCase,
    private val getNoticeCommentListUseCase: GetNoticeCommentListUseCase,
    private val addNoticeCommentUseCase: AddNoticeCommentUseCase,
    private val deleteCommentUseCase: DeleteCommentUseCase,
    private val reportUseCase: ReportUseCase,
    private val getChildCommentListUseCase : GetChildCommentListUseCase,
    private val addNoticeChildCommentUseCase : AddNoticeChildCommentUseCase
) : ViewModel() {

    val noticeId: Int = savedStateHandle.get<Int>(NOTICE_ID_SAVED_STATE_KEY)!!

    private val _commentList = MutableStateFlow<List<CommentModel>>(emptyList())
    val commentList : StateFlow<List<CommentModel>> = _commentList.asStateFlow()

    private val _childCommentList = MutableStateFlow<List<CommentModel>>(emptyList())
    val childCommentList : StateFlow<List<CommentModel>> = _childCommentList.asStateFlow()

    private val _snackbarEvent = MutableSharedFlow<NoticeDetailSnackbarEvent>()
    val snackbarEvent : SharedFlow<NoticeDetailSnackbarEvent> = _snackbarEvent.asSharedFlow()

    private val _dialogEvent = MutableSharedFlow<NoticeDetailDialogEvent>()
    val dialogEvent : SharedFlow<NoticeDetailDialogEvent> = _dialogEvent.asSharedFlow()

    init {
        fetchCommentList()
    }

    val notice = getNoticeDetailUseCase(noticeId).catch {
        _snackbarEvent.emit(NoticeDetailSnackbarEvent.NETWORK_ERROR)
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = NoticeModel()
    )

    fun fetchCommentList() {
        viewModelScope.launch {
            getNoticeCommentListUseCase(
                noticeId
            ).catch {
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.NETWORK_ERROR)
            }.collectLatest {
                _commentList.emit(it)
            }
        }
    }

    fun fetchChildCommentList(
        commentId: Int
    ) {
        viewModelScope.launch {
            getChildCommentListUseCase(
                commentId
            ).catch {
                // TODO
            }.collectLatest {
                _childCommentList.emit(it)
            }
        }
    }

    fun clearChildCommentList() {
        viewModelScope.launch {
            _childCommentList.emit(emptyList())
        }
    }


    fun addNoticeComment(
        content : String
    ){
        viewModelScope.launch {
            addNoticeCommentUseCase(
                noticeId = noticeId,
                content = CommentContentModel(content)
            ).catch {
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.NETWORK_ERROR)
            }.collectLatest {
               fetchCommentList()
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.ADDED_COMMENT)
            }
        }
    }

    fun addNoticeChildComment(
        commentId: Int,
        content : String
    ){
        viewModelScope.launch {
            addNoticeChildCommentUseCase(
                noticeId = noticeId,
                commentId = commentId,
                content = CommentContentModel(content)
            ).catch {
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.NETWORK_ERROR)
            }.collectLatest {
                fetchCommentList()
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.ADDED_COMMENT)
            }
        }
    }

    fun deleteNoticeComment(
        commentId : Int
    ){
        viewModelScope.launch {
            deleteCommentUseCase(
                commentId = commentId
            ).catch {
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.NETWORK_ERROR)
            }.collectLatest {
                fetchCommentList()
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.DELETED_COMMENT)
            }
        }
    }

    fun reportNoticeComment(
        memberId : Int,
        commentId : Int,
        content : String
    ){
        viewModelScope.launch {
            reportUseCase(
                ReportCommentContentModel(
                    memberId,
                    commentId,
                    content
                )
            ).catch {
                _snackbarEvent.emit(NoticeDetailSnackbarEvent.NETWORK_ERROR)
            }.collectLatest {
                fetchCommentList()
                when(it){
                    ReportResult.ALREADY_REPORTED -> _dialogEvent.emit(NoticeDetailDialogEvent.ALREADY_REPORTED_COMMENT)
                    ReportResult.SUCCESS -> _snackbarEvent.emit(NoticeDetailSnackbarEvent.REPORTED_COMMENT)
                }
            }
        }
    }

    companion object {
        private const val NOTICE_ID_SAVED_STATE_KEY = "noticeId"

        enum class NoticeDetailSnackbarEvent {
            ADDED_COMMENT, DELETED_COMMENT, REPORTED_COMMENT, NETWORK_ERROR
        }

        enum class NoticeDetailDialogEvent {
            ALREADY_REPORTED_COMMENT
        }
    }
}