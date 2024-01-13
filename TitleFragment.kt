package com.example.tossit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.tossit.R


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_title, container, false)

        val coinButton = rootView.findViewById<Button>(R.id.SelectCoin)

        val multiButton = rootView.findViewById<Button>(R.id.SelectMP)

        multiButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_titleFragment_to_MultiPlayerFragment)
        }

        // setting navigation for onclick coin button
        coinButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_titleFragment_to_twoPlayerFragment)
        }

        return rootView
    }


}