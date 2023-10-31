package com.kusitms.presentation.model.signIn

import com.kusitms.presentation.R


data class LikeCategory(
    val id: Int,
    val name: String,
    val icon: Int? = null,
    val subCategories:List<String>
    )

val categories = listOf(
    LikeCategory(1,"기획", R.drawable.ic_category_product,listOf("PM PO", "서비스 기획", "전략 기획", "사업 기획", "프로덕트 관리", "데이터 분석")),
    LikeCategory(2,"개발", R.drawable.ic_category_dev, listOf("일반 개발", "웹 개발", "Javascript", "React", "Vue.js", "Angular", "Node.js", "Spring", "Java", "Python", "PHP", "Database", "Android", "iOS", "Git", "AI, 머신러닝")),
    LikeCategory(3, "디자인",R.drawable.ic_category_design, listOf("일반 디자인", "UI/UX", "브랜드 디자인", "광고 디자인", "영상 디자인")),
    LikeCategory(4, "기타", null , listOf("마케팅", "스타트업")),
)