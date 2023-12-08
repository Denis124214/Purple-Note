package com.example.mypettodolist.data

import androidx.lifecycle.LiveData;
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// ОПЕРАЦИЙ НЕЛЬЗЯ ДЕЛАТЬ НА ОСНОВНОМ ПОТОКЕ. ДЕЛАЙ В COROUTINES
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //onConflict с аргументом OnConflictStrategy.IGNORE указывает Room, что при возникновении конфликта необходимо игнорировать новые данные и не выполнять вставку, если уже существует запись с тем же ключом или уникальным значением. В этом случае новые данные будут проигнорированы, и уже существующие данные останутся неизменными.
    suspend fun addNote(note : NoteEntity)

    @Query("SELECT * FROM NoteEntity ORDER BY uid ASC") // В данном случае запрос "SELECT * FROM note_table ORDER BY uid ASC" выбирает все столбцы (*) из таблицы note_table и упорядочивает результаты по значению столбца uid в порядке возрастания (ASC).
    fun readAllData(): LiveData<List<NoteEntity>> //

}