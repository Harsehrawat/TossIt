package com.example.tossit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class MultiPlayerFragments : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_multi_player, container, false)

        val nextButton = rootView.findViewById<Button>(R.id.nextButton)
        val inputEditText = rootView.findViewById<EditText>(R.id.inputEditText)

        // sharedViewmodel ko access
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        nextButton.setOnClickListener { view : View ->
            val userInput = inputEditText.text.toString().toIntOrNull()
            if (userInput!=null) {
                viewModel.inputValue = userInput

                findNavController().navigate(R.id.action_MultiPlayerFragment_to_resultMultiPlayerFragment)
            }
        }

        return rootView
    }


}