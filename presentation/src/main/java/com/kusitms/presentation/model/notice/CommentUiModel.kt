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

val dummyCommentList = listOf(
    CommentUiModel(
        2,
        1,
        "학교 시험으로 불참하게 되면 벌점을 받을까요?",
        "03/23 23:32",
        false,
            false,
        "",
        "박민지",
        1
    ),
    CommentUiModel(
        24,
        2,
        "아래로 확인댓글 달아주세요!",
        "03/23 23:32",
        false,
        false,
        "",
        "이지현",
        2
    )
)