package com.kusitms.data.remote.entity.response.notice

import com.kusitms.domain.model.notice.CommentModel

data class CommentPayload(
    val commentCount: Int? = 0,
    val commentId: Int? = 0,
    val content: String? = "",
    val createdAt: String? = "",
    val isAnonymous: Boolean? = false,
    val isMine: Boolean? = false,
    val profileImageUrl: String? = "",
    val writer: String? = "",
    val writerId: Int? = 0
)

fun CommentPayload.toModel() =
    CommentModel(
        commentCount = commentCount ?: 0,
        commentId = commentId ?: 0,
        content = content ?: "",
        createdAt = createdAt ?: "",
        isAnonymous = isAnonymous ?: false,
        isMine = isMine ?: false,
        profileImageUrl = profileImageUrl ?: "",
        writer = writer ?: "",
        writerId = writerId ?: 0
)