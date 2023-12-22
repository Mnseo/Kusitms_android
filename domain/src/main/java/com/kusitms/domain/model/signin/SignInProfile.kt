package com.kusitms.domain.model

data class SignInProfile(
    val major: String,
    val part: String,
    val interests: List<Interest>,
    val description: String,
    val links: List<Link>
)

data class Interest(
    val category: String,
    val content: String
)

data class Link(
    val type: String,
    val link: String
)