package com.info.todo.local
//
//import android.content.Context
//import androidx.room.Room
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.internal.managers.ApplicationComponentManager
//import dagger.hilt.components.SingletonComponent
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object Module {
//
//    @Provides
//    fun provideDb(context:Context):TodoDataBase{
//        return Room.databaseBuilder(context,TodoDataBase::class.java,"todo_database").build()
//    }
//
//    @Provides
//    fun provideDao(dataBase: TodoDataBase):TodoDao{
//        return dataBase.todoDao()
//    }
//
//
//}