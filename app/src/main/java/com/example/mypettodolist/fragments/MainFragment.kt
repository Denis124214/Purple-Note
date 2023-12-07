package com.example.mypettodolist.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypettodolist.R
import com.example.mypettodolist.model.NoteEntity
import com.example.mypettodolist.screens.main.Adapter

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = Adapter()
        val noteList = listOf(R.drawable.blank_image, "sadsad", "dsaad", "daadas", "dasdsa")
        var index = 0
        val reView = view.findViewById<RecyclerView>(R.id.reView)

        val addBtn = view.findViewById<ConstraintLayout>(R.id.addBtn)
        val plusBtn = view.findViewById<ImageButton>(R.id.plusBtn)

        fun init () {
            apply {// получем доступ
                reView.layoutManager = GridLayoutManager(requireContext(),1)
                reView.adapter = adapter
                plusBtn.setOnClickListener{
                    if (index > 4) index = 0 // если index > 4, то index = 0
                    val note = NoteEntity(34,  "34234", "324234", "Note $index")
                    adapter.addNote(note)
                    index++
                }

            }
        }

        init()
//        val controller = findNavController()

//        addBtn.setOnClickListener {
//            controller.navigate(R.id.todoDetailFragment)
//            Log.d("Click", "successfully clicled")
//        }
//
//        plusBtn.setOnClickListener {
//            controller.navigate(R.id.todoDetailFragment)
//            Log.d("Click", "successfully clicled")
//        }

}}