package com.example.mypettodolist.data

import androidx.lifecycle.LiveData

class NoteRepository (private val noteDao: NoteDao) { // Конструктор класса NoteRepository принимает noteDao, который будет использоваться для выполнения операций с базой данных. NoteDao - это интерфейс, предоставляющий абстракцию для доступа к базе данных.

    val readAllData: LiveData<List<NoteEntity>> = noteDao.readAllData() // Это свойство, которое содержит список всех объектов Note из базы данных. Оно использует LiveData, чтобы можно было наблюдать за изменениями данных в режиме реального времени.

    suspend fun addNote(note: NoteEntity) { // Это функция, которая добавляет новую запись Note в базу данных. Она использует ключевое слово suspend, которое указывает, что эта функция должна вызываться из корутина или другой асинхронной функции.
        noteDao.run { addNote(note) } // Внутри функции addNote используется расширение run, чтобы вызвать метод addNote из noteDao. Этот метод добавляет новую запись Note в базу данных.
    }

}