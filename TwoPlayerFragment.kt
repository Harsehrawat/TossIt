package com.example.tossit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random


class TwoPlayerFragment : Fragment() {

    private lateinit var coin : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_two_player, container, false)

        val tossCoin = rootView.findViewById<Button>(R.id.tosscoinButton)
        tossCoin.setOnClickListener { view:View ->
            tossingCoin()
        }

        coin = rootView.findViewById<ImageView>(R.id.tossImage)
        return rootView

    }

    private fun tossingCoin(){
        val randomInt = Random.Default.nextInt(1,3)
        val result = when(randomInt){
            1 -> R.drawable.coin_head
            else -> R.drawable.coin_tails
        }
        coin.setImageResource(result)
        Toast.makeText(requireContext(), "Coin Tossed", Toast.LENGTH_SHORT).show()


    }

}