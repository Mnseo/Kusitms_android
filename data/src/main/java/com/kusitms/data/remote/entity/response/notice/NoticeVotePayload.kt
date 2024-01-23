package com.kusitms.data.remote.entity.response.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.NoticeVoteItem
import com.kusitms.domain.model.notice.NoticeVoteMember
import com.kusitms.domain.model.notice.NoticeVoteModel

data class NoticeVotePayload(
    val items: List<NoticeVoteItemPayload>? = emptyList(),
    val title: String? = "",
    val total: Int? = 0,
    val voteAttendId: Int? = 0,
    val voteId: Int? = 0
)

data class NoticeVoteItemPayload(
    val count: Int? = 0,
    val item: String? = "",
    val members: List<NoticeVoteMemberPayload>? = emptyList(),
    val voteItemId: Int? = 0
)

data class NoticeVoteMemberPayload(
    val memberId: Int? = 0,
    val name: String? = "",
    val profileImageUrl: String? = ""
)

fun NoticeVotePayload.toModel() =
    NoticeVoteModel(
        items = items?.map { it.toModel() } ?: emptyList(),
        total = total ?: 0,
        title = title ?: "",
        voteAttendId = voteAttendId ?: 0,
        voteId = voteId ?: 0
    )

fun NoticeVoteItemPayload.toModel() =
    NoticeVoteItem(
        count = count ?: 0,
        item = item ?: "0",
        members = members?.map { it.toModel() } ?: emptyList(),
        voteItemId = voteItemId ?: 0
    )

fun NoticeVoteMemberPayload.toModel() =
    NoticeVoteMember(
        memberId = memberId ?: 0,
        name = name ?: "",
        profileImageUrl = profileImageUrl ?: ""
    )