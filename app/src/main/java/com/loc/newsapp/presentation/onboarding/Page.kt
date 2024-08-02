package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Page title",
        "Page description this is description so it has some more content",
        R.drawable.onboarding1
    ),
    Page(
        "Page title 2",
        "Page description this is description so it has some more content",
        R.drawable.onboarding2
    ),
    Page(
        "Page title 3",
        "Page description this is description so it has some more content",
        R.drawable.onboarding3
    )
)
