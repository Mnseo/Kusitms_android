package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.notice.CommentContentModel

data class CommentContentRequestBody(
    val content : String
)

fun CommentContentModel.toBody() =
    CommentContentRequestBody(
        content = content
    )