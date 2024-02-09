package com.kusitms.presentation.model.signIn

import androidx.annotation.DrawableRes
import com.kusitms.presentation.R

data class LinkCategory(
    val linkType: LinkType,
)

data class LinkItem(
    val linkType: LinkType,
    val linkUrl: String
)

enum class LinkType(val displayName: String, @DrawableRes val iconRes: Int?) {
    LINK("Link", R.drawable.ic_link),
    BRUNCH("Brunch", R.drawable.ic_brunch),
    TISTORY("Tistory", R.drawable.ic_tistory),
    NOTION("Notion", R.drawable.ic_notion),
    BEHANCE("Behance", R.drawable.ic_behance),
    LINKEDIN("Linkedin", R.drawable.ic_linkedin),
    GITHUB("Github", R.drawable.ic_github)
}

val linkCategories = LinkType.values().map { linkType ->
    LinkCategory(linkType)
}


