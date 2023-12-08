package com.example.mypettodolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase { //getDatabase: Это функция для получения экземпляра базы данных. Она принимает контекст приложения и возвращает объект базы данных NoteDatabase.Context. Этот контекст обычно используется для доступа к ресурсам и службам приложения.
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) { // только 1 поток может
                val instance = databaseBuilder( // Room.databaseBuilder. Этот метод создает и возвращает новый экземпляр базы данных, если он еще не был инициализирован.
                    context.applicationContext, // контекст приложения
                    AppDatabase::class.java, // класс бд
                    "note_database" // имя бд. Это все принимает
                ).build() // создает экземпляр базы данных и возвращает его.
                INSTANCE = instance
                return  instance
            }
        }
}}
