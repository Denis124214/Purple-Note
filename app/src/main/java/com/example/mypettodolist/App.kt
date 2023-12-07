//package com.example.mypettodolist
//
//import android.app.Application
//import androidx.room.Room
//import androidx.room.Room.databaseBuilder
//import com.example.mypettodolist.data.AppDatabase
//import com.example.mypettodolist.data.NoteDao
//
//class App : Application() {
//    class App private constructor() {
//        companion object {
//            private var instance: App? = null
//
//            fun getInstance(): App {
//                if (instance == null) {
//                    instance = App()
//                }
//                return instance as App
//            }
//        }
//
//        override fun onCreate() {
//            super.onCreate()
//            instance = this
//
//            companion
//            val database: AppDatabase by lazy {
//                Room.databaseBuilder(
//                    applicationContext,
//                    AppDatabase::class.java,
//                    "app-db-name"
//                ).build()
//            }
//
//            val noteDao: NoteDao by lazy { database.noteDao() }
//        }
//    }
//}
