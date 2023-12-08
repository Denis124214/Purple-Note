package com.example.mypettodolist.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mypettodolist.R
import com.example.mypettodolist.data.NoteEntity
import com.example.mypettodolist.data.NoteViewModel

class TodoDetailFragment : Fragment() {
    private lateinit var mNoteViewModel: NoteViewModel
    lateinit var editText: EditText
    private lateinit var readAllData: LiveData<List<NoteEntity>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize noteViewModel correctly
        mNoteViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application))
            .get(NoteViewModel::class.java)

        val back = view.findViewById<ImageButton>(R.id.detailsBackBtn)

        // Initialize readAllData here
        readAllData = mNoteViewModel.readAllData

        back.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val title = view?.findViewById<EditText>(R.id.detailTitle)?.text.toString()
        val suptitle = view?.findViewById<EditText>(R.id.detailDate)?.text.toString()
        val edit = view?.findViewById<EditText>(R.id.detailEdit)?.text.toString()

        if (inputCheck(title, suptitle, edit)) {
            // Create note Object
            val note = NoteEntity(0, title, suptitle, edit)
            // Add Data to Database using ViewModel
            mNoteViewModel.addNote(note)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.mainFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(title: String, suptitle: String, edit: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(suptitle) && TextUtils.isEmpty(edit))
    }
}
