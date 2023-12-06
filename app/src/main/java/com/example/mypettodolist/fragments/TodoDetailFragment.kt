package com.example.mypettodolist.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.mypettodolist.R

class TodoDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = findNavController()

        val back = view.findViewById<ImageButton>(R.id.detailsBackBtn)

        back.setOnClickListener {
            controller.navigate(R.id.action_todoDetailFragment_to_mainFragment)
            Log.d("Click", "successfully clicked")
        }
    }
}
