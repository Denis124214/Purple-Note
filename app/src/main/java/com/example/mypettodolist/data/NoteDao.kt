package com.example.mypettodolist.data

import androidx.lifecycle.LiveData;
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mypettodolist.model.NoteEntity

// ОПЕРАЦИЙ НЕЛЬЗЯ ДЕЛАТЬ НА ОСНОВНОМ ПОТОКЕ. ДЕЛАЙ В COROUTINES
@Dao
interface NoteDao {
    @Query("SELECT * FROM NoteEntity") // Query - считывание
    fun getAllItem(): List<NoteEntity>

    @Query("SELECT * FROM NoteEntity")
    fun getAllLiveData(): List<NoteEntity>

    @Query("SELECT * FROM NoteEntity WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<NoteEntity>

    @Query("SELECT * FROM NoteEntity WHERE uid = :uid LIMIT 1")
    fun findById(uid: Int): NoteEntity

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert( noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)
}