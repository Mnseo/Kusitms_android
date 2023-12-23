package com.kusitms.domain.model.notice

data class CommentModel(
    val commentCount: Int,
    val commentId: Int,
    val content: String = "",
    val createdAt: String,
    val isAnonymous: Boolean,
    val isMine: Boolean,
    val profileImageUrl: String,
    val writer: String,
    val writerId: Int
)