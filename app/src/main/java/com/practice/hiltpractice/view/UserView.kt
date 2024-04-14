package com.practice.hiltpractice.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.practice.hiltpractice.model.Screen
import com.practice.hiltpractice.model.data.User
import com.practice.hiltpractice.viewModel.UserViewModel

@Composable
fun MyApp(userViewModel: UserViewModel, navController: NavHostController) {
    val users by userViewModel.users.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(users) {
            UserCard(it) {
                userViewModel.deleteUser(it)
            }

        }
        item {
            Row {
                Button(onClick = { navController.navigate(Screen.Create.route) }) {
                    Text(text = "생성")
                }
            }
        }
    }
}

@Composable
private fun UserCard(user: User, onClicked: () -> Unit) {
    Column {
        Text(text = "${user.id}")
        Text(text = user.name)
        Text(text = user.email)
        Button(onClick = { onClicked() }) {
            Text(text = "삭제")
        }
    }
}

@Composable
fun NewUser(viewModel: UserViewModel, navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(value = name, onValueChange = { name = it })
        TextField(value = email, onValueChange = { email = it })
        Button(onClick = {
            val user = User(name = name, email = email)
            viewModel.insertUser(user)
            navController.popBackStack()

        }) {
            Text(text = "완료 저장")
        }
    }

}