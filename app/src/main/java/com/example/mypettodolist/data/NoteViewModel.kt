package com.example.mypettodolist.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.mypettodolist.data.AppDatabase
import com.example.mypettodolist.data.NoteRepository
import com.example.mypettodolist.data.NoteEntity

class NoteViewModel (application: Application): AndroidViewModel(application) { //является классом, расширяющим AndroidViewModel, который предоставляет Application в качестве контекста. Это обеспечивает доступ к ресурсам приложения и контексту приложения из NoteViewModel. (application: Application) - контекст. application имеет доступ к ресурсам приложения

    val readAllData: LiveData<List<NoteEntity>> //readAllData представляет объект LiveData, который содержит список всех объектов Note. Этот объект LiveData обновляется автоматически при изменении данных в базе данных, и любые подписчики этого объекта будут оповещены об изменениях.
    private val repository: NoteRepository //repository - это экземпляр NoteRepository, который обеспечивает абстракцию для доступа к данным Note и выполняет операции чтения и записи с базой данных.

    init { //инициализирует два приватных свойства: readAll Data и repository.
        val noteDao = AppDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllData =repository.readAllData
    }

    fun addNote (note: NoteEntity) { // Метод addNote использует viewModelScope.launch для запуска новой корутины в контексте Dispatchers.IO. Внутри этой корутины вызывается метод addNote из repository, который добавляет новый объект Note в базу данных.
        viewModelScope.launch(Dispatchers.IO) {//Использование viewModelScope позволяет автоматически отменять все корутины, связанные с ViewModel, при уничтожении ViewModel, что предотвращает утечки ресурсов и обеспечивает безопасное выполнение асинхронных операций. Выполнение операций в контексте Dispatchers.IO позволяет выполнять ввод-выводные операции без блокировки основного потока приложения.
            repository.addNote(note)
        }
    }
}