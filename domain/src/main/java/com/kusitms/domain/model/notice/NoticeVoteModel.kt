package com.kusitms.domain.model.notice

data class NoticeVoteModel(
    val items: List<NoticeVoteItem> = emptyList(),
    val title: String = "",
    val total: Int = 0,
    val voteAttendId: Int = 0,
    val voteId: Int = 0
)

data class NoticeVoteItem(
    val count: Int = 0,
    val item: String = "",
    val members: List<NoticeVoteMember> = emptyList(),
    val voteItemId: Int = 0,
    val selected : Boolean = false
)

data class NoticeVoteMember(
    val memberId: Int = 0,
    val name: String = "",
    val profileImageUrl: String = ""
)