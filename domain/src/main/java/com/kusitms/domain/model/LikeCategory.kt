package com.kusitms.domain.model

data class LikeCategory(val name: String, val subCategories:List<String>)

val categories = listOf(
    LikeCategory("기획", listOf("PM PO", "서비스 기획", "전략 기획", "사업 기획", "프로덕트 관리", "데이터 분석")),
    LikeCategory("개발", listOf("일반 개발", "웹 개발", "Javascript", "React", "Vue.js", "Angular", "Node.js", "Spring", "Java", "Python", "PHP", "Database", "Android", "iOS", "Git", "AI, 머신러닝")),
    LikeCategory("디자인", listOf("일반 디자인", "UI/UX", "브랜드 디자인", "광고 디자인", "영상 디자인")),
    LikeCategory("기타", listOf("마케팅", "스타트업")),
)