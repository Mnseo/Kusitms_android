package com.kusitms.presentation.ui.notice.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.notice.CommentContentModel
import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.ReportCommentContentModel
import com.kusitms.domain.model.report.ReportContentModel
import com.kusitms.domain.usecase.notice.AddNoticeCommentUseCase
import com.kusitms.domain.usecase.notice.DeleteCommentUseCase
import com.kusitms.domain.usecase.notice.GetNoticeCommentListUseCase
import com.kusitms.domain.usecase.notice.GetNoticeDetailUseCase
import com.kusitms.domain.usecase.report.ReportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NoticeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getNoticeDetailUseCase: GetNoticeDetailUseCase,
    private val getNoticeCommentListUseCase: GetNoticeCommentListUseCase,
    private val addNoticeCommentUseCase: AddNoticeCommentUseCase,
    private val deleteCommentUseCase: DeleteCommentUseCase,
    private val reportUseCase: ReportUseCase
) : ViewModel() {

    val noticeId: Int = savedStateHandle.get<Int>(NOTICE_ID_SAVED_STATE_KEY)!!

    private val _commentList = MutableStateFlow<List<CommentModel>>(emptyList())
    val commentList : StateFlow<List<CommentModel>> = _commentList.asStateFlow()

    init {
        fetchCommentList()
    }

    val notice = getNoticeDetailUseCase(noticeId).catch {
        //TODO 에러처리
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
                //TODO
            }.collectLatest {
                _commentList.emit(it)
            }
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
                //TODO
            }.collectLatest {
                // TODO 수정
               fetchCommentList()
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
                //TODO
            }.collectLatest {
                fetchCommentList()
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
                //TODO
            }.collectLatest {
                fetchCommentList()
            }
        }
    }

    companion object {
        private const val NOTICE_ID_SAVED_STATE_KEY = "noticeId"
    }
}