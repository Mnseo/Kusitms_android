package com.kusitms.domain.model.notice

data class NoticeVoteModel(
    val items: List<NoticeVoteItem> = emptyList(),
    val title: String = "",
    val total: Int = 0,
    val voteAttendId: Int = 0,
    val voteId: Int = 0,
    val possibleVote : VotingStatus = VotingStatus.PreVoting
)

data class NoticeVoteItem(
    val count: Int = 0,
    val item: String = "",
    val members: List<NoticeVoteMember> = emptyList(),
    val voteItemId: Int = 0,
    val isVoted : Boolean = false
)

data class NoticeVoteMember(
    val memberId: Int = 0,
    val name: String = "",
    val profileImageUrl: String = ""
)

enum class VotingStatus {
    PreVoting, // 투표 참여 전
    ReVoting, // 다시 투표 가능
    VotingEnded // 투표 종료
}

