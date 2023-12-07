package com.example.mypettodolist.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypettodolist.R
import com.example.mypettodolist.databinding.NoteItemBinding
import com.example.mypettodolist.model.NoteEntity

class Adapter : RecyclerView.Adapter<Adapter.NoteHolder>() { //<PlantAdapter.PlantHolder> - тип вашего ViewHolder. Создаем его ниже
    val noteList = ArrayList<NoteEntity>() // Этот список будет использоваться для хранения объектов класса Plant.
    class NoteHolder (item: View): RecyclerView.ViewHolder (item) { // class viewHolder. Каждый класс имеет сссылки на свои элементы
        val binding = NoteItemBinding.bind(item) // PlantItemBinding.bind(item) используется для связывания элементов макета с объектами в коде.
        fun bind(note: NoteEntity)  { // можно здесь with(binding написать, чтобы не пришлось ниже binding писать
            binding.titleItem.text = note.title
            binding.suptitleItem.text = note.text
            binding.timeItem.text = note.date// вроде понятно
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder { // берет разметку и создает класс PlantHolder (новый viewHolder). СОЗДАЕТСЯ реальный view. . Когда вы создаете новый View для элемента списка, этот View затем будет добавлен в parent. parent предоставляет контекст, в котором будет располагаться элемент списка.
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int { // передаем размер массива. adapter будет знать, сколко раз запустить
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) { // Заполняем View, который создали. знает сколько раз зап-ть onCreateViewHolder. ЗАПОЛЯНЕТЬСЯ. position в onBindViewHolder - аналог index в массивах
        holder.bind(noteList[position])
    }

    fun addNote (note: NoteEntity) { // при нажатии добавляеться новый элемент
        noteList.add(note)
        notifyDataSetChanged() // перерисовывает
    }
}