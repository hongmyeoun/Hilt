package com.practice.hiltpractice.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.hiltpractice.model.Screen
import com.practice.hiltpractice.viewModel.UserViewModel

@Composable
fun HiltTestApp(userViewModel: UserViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route){
            MyApp(userViewModel, navController)
        }
        composable(Screen.Create.route){
            NewUser(viewModel = userViewModel, navController = navController)
        }
    }
}