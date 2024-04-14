package com.practice.hiltpractice.model.di

import android.content.Context
import androidx.room.Room
import com.practice.hiltpractice.model.data.UserDao
import com.practice.hiltpractice.model.data.UserDatabase
import com.practice.hiltpractice.model.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) : UserDatabase {
        return Room.databaseBuilder(
            appContext,
            UserDatabase::class.java,
            "my.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(userDatabase: UserDatabase) : UserDao {
        return userDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao) : UserRepository {
        return UserRepository(userDao)
    }
}