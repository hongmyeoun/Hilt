package com.practice.hiltpractice.model

sealed class Screen(val route: String) {
    data object Main : Screen("Main")
    data object Create : Screen("Create")
}