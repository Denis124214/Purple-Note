package com.example.mypettodolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypettodolist.R
import com.example.mypettodolist.data.NoteEntity
import com.example.mypettodolist.data.NoteViewModel
import com.example.mypettodolist.screens.main.Adapter

class MainFragment : Fragment() {
    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        // Inflate the layout for this fragment
        val addBtn = view.findViewById<ConstraintLayout>(R.id.addBtn)
        val plusBtn = view.findViewById<ImageButton>(R.id.plusBtn)

        // RecyclerView
        val adapter = Adapter()
        val resyclerView: RecyclerView =
            view.findViewById(R.id.reView) //Создается экземпляр адаптера ListAdapter и устанавливается в RecyclerView.Устанавливается LinearLayoutManager, который определяет, как элементы списка будут расположены (в данном случае, вертикально).
        resyclerView.adapter = adapter
        resyclerView.layoutManager = LinearLayoutManager(requireContext())

        // NoteViewModel
        mNoteViewModel =
            ViewModelProvider(this).get(NoteViewModel::class.java) //следит за изменениями в readAllData и обновляет данные в адаптере при изменении.
        mNoteViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        plusBtn.setOnClickListener {
            findNavController().navigate(R.id.todoDetailFragment) // findNavController() ( метод, который находит контроллер навигации для текущего фрагмента).navigate() (Он используется для запуска перехода от одного фрагмента к другому) говорит приложению начать переход между фрагментами
        }

        return view
    }
}