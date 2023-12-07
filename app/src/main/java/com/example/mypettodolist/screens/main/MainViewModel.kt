//package com.example.mypettodolist.screens.main
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import com.example.mypettodolist.data.AppDatabase
//import com.example.mypettodolist.model.NoteEntity
//
//class MainViewModel : ViewModel() {
//    private val noteDao = AppDatabase.getInstance(requireContext).getDao()
//    private val noteLiveData: LiveData<List<NoteEntity>> = noteDao.getAllLiveData()
//
//    fun getNoteLiveData(): LiveData<List<NoteEntity>> {
//        return noteLiveData
//    }
//}