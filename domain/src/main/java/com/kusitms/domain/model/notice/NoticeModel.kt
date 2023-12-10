package com.kusitms.domain.model.notice

data class NoticeModel(
    val noticeId : Int,
    val curriculum : String = "",
    val team : String = "",
    val title : String,
    val content : String,
    val date : String,
    val imageUrl : String = "",
    val isRead : Boolean = false,
    val name : String = "",
    val profileImage : String = ""
)

val noticeDummy = listOf(
    NoticeModel(
        0,
        "기타공지",
        "경영총괄",
        "학회비 공지",
        "안녕하세요! 큐시즘 27기 경영총괄팀 회계 담당 하현정입니다☺️ 먼저 큐시즘에 합격하신 여러분들을 진심으로 환영합니다!!\uD83E\uDD39\uD83C\uDFFB\u200D♀️",
        "09.05",
        isRead = true,
        name = "이지현"
    ),
    NoticeModel(
        1,
        "기타공지",
        "대외홍보",
        "큐시즘 공식 네이버 카페 가입 및 등업 공지",
        "안녕하세요 27기 대외홍보팀장 김시연입니다\uD83E\uDD29 먼저 27기 큐밀리가 되신것을 정말 축하드립니다!\uD83E\uDD73\uD83C\uDF89\n",
        "09.05"
    ),
    NoticeModel(
        2,
        "전체OT",
        "학부학",
        "27기 OT 프로그램 신청",
        "안녕하세요, 학회장 박형준입니다. 이번 기수가 진행되는 동안 양질의 교육 커리큘럼을 진행하기 위해 상상유니브와 협력하여 OT때 ✨상상유니브 캠퍼스어택✨을 진행하게 되었습니다.",
        "09.04",
        isRead = true
    ),
    NoticeModel(
        3,
        "전체OT",
        "경영총괄",
        "27기 OT 안내 및 참/불참 조사",
        "안녕하세요! 경영총괄팀장 이지현입니다\uD83C\uDF3F 높은 경쟁률을 뚫고 큐시즘에 합격하신 여러분 정말 반갑습니다! 이번주 토요일에 진행될 큐시즘의 첫 행사, 오리엔테이션에 대해 안내 드리겠습니다.\n",
        "09.01",
        isRead = true
    ),
    NoticeModel(
        4,
        "기타공지1",
        "경영총괄1",
        "학회비 공지1",
        "안녕하세요! 큐시즘 27기 경영총괄팀 회계 담당 하현정입니다☺️ 먼저 큐시즘에 합격하신 여러분들을 진심으로 환영합니다!!\uD83E\uDD39\uD83C\uDFFB\u200D♀️",
        "09.05"
    ),
    NoticeModel(
        5,
        "기타공지1",
        "대외홍보1",
        "큐시즘 공식 네이버 카페 가입 및 등업 공지1",
        "안녕하세요 27기 대외홍보팀장 김시연입니다\uD83E\uDD29 먼저 27기 큐밀리가 되신것을 정말 축하드립니다!\uD83E\uDD73\uD83C\uDF89\n",
        "09.05"
    ),
    NoticeModel(
        6,
        "전체OT1",
        "학부학1",
        "27기 OT 프로그램 신청1",
        "안녕하세요, 학회장 박형준입니다. 이번 기수가 진행되는 동안 양질의 교육 커리큘럼을 진행하기 위해 상상유니브와 협력하여 OT때 ✨상상유니브 캠퍼스어택✨을 진행하게 되었습니다.",
        "09.04",
        isRead = true
    ),
    NoticeModel(
        7,
        "전체OT1",
        "경영총괄1",
        "27기 OT 안내 및 참/불참 조사1",
        "안녕하세요! 경영총괄팀장 이지현입니다\uD83C\uDF3F 높은 경쟁률을 뚫고 큐시즘에 합격하신 여러분 정말 반갑습니다! 이번주 토요일에 진행될 큐시즘의 첫 행사, 오리엔테이션에 대해 안내 드리겠습니다.\n",
        "09.01"
    )
)