package com.example.tossit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels
import kotlin.random.Random


class ResultMultiPlayerFragment : Fragment() {

    private lateinit var viewModel : SharedViewModel
    private lateinit var resultTextView : TextView
    private lateinit var shuffleButton: Button
    private val shuffledNumbers = mutableListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_result_multi_player, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        resultTextView = rootView.findViewById(R.id.randomNoText)


        val shuffleButton = rootView.findViewById<Button>(R.id.shuffleButton)
        shuffleButton.setOnClickListener {
            displayDistinctRandomNumbers()
        }

        return rootView
    }

    private fun displayDistinctRandomNumbers() {
        val inputValue = viewModel.inputValue

        if (inputValue > 0) {
            val remainingNumbers = generateRemainingDistinctNumbers(inputValue)

            if (remainingNumbers.isNotEmpty()) {
                val randomIndex = Random.nextInt(remainingNumbers.size)
                val selectedNumber = remainingNumbers[randomIndex]
                resultTextView.text = selectedNumber.toString()

                shuffledNumbers.add(selectedNumber)
            } else {
                Toast.makeText(requireContext(), "All positions have been shown", Toast.LENGTH_SHORT).show()
            }
        } else {
            resultTextView.text = "Invalid input value"
        }
    }

    private fun generateRemainingDistinctNumbers(maxValue: Int): List<Int> {
        val numbers = (1..maxValue).toList()
        val remainingNumbers = numbers.filterNot {it in shuffledNumbers}
        return remainingNumbers
    }
}