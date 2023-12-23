package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.notice.CommentContentModel
import com.kusitms.domain.model.notice.ReportCommentContentModel

data class ReportCommentRequestBody(
    val memberId : Int,
    val commentId : Int,
    val content : String
)

fun ReportCommentContentModel.toBody() =
    ReportCommentRequestBody(
        memberId = memberId,
        commentId = commentId,
        content = content
    )