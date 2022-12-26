package com.fox.composelearning.navigation

sealed class Screen(val screenName: String, val resourceId: Int) {
    object Main: Screen("main", -1)
}
