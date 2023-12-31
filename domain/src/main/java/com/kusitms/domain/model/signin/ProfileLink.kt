package com.kusitms.domain.model.signin

data class ProfileLink(
    val type: LinkType,
    val links: String
)

enum class LinkType {
    LINK, BRUNCH, TISTORY, NOTION, BEHANCE, LINKEDIN, GITHUB
}
