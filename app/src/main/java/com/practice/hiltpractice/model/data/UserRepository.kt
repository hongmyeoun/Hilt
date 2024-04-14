package com.practice.hiltpractice.model.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}