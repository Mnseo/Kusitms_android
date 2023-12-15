package com.kusitms.presentation.model.notice

data class CommentUiModel(
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
