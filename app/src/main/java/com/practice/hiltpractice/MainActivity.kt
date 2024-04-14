package com.practice.hiltpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.practice.hiltpractice.ui.theme.HilttestTheme
import com.practice.hiltpractice.view.HiltTestApp
import com.practice.hiltpractice.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HilttestTheme {
                HiltTestApp(userViewModel)
            }
        }
    }
}

