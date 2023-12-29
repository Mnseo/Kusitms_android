package com.kusitms.presentation.model.signIn

import com.kusitms.presentation.R

data class LinkCategory(
    val id: Int,
    val name: String,
    val icon: Int? = null
)

val linkCategories = listOf(
    LinkCategory(1, "깃허브", R.drawable.ic_category_design),
    LinkCategory(2, "노션", R.drawable.ic_category_design),
    LinkCategory(3, "비핸스", R.drawable.ic_category_design),
    LinkCategory(4, "티스토리", R.drawable.ic_category_design),
    LinkCategory(5, "벨로그", R.drawable.ic_category_design)

)
