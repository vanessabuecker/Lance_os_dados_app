package com.vbuecker.app_dice_play_devventure

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.FragmentDiceRollBinding

class DiceRollFragment : Fragment() {

    private var binding: FragmentDiceRollBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentDiceRollBinding.inflate(inflater, container, false)

        var regularPlayer = arguments?.getString("regularPlayer") ?: ""
        arguments?.getString("regularPlayer")

        if (regularPlayer.isBlank()) {
            regularPlayer = "Jogador (a)"
        }

        binding?.textViewTitle?.text = getString(R.string.welcome, regularPlayer)

        binding?.button?.setOnClickListener {
            rollDice()
        }

        return binding?.root
    }

    fun rollDice() {
        val drawableResource = when (java.util.Random().nextInt(6) + 1) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else
            -> R.drawable.dice6
        }

        binding?.dice1?.setImageResource(drawableResource)

        val drawableResource2 = when (java.util.Random().nextInt(6) + 1) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else
            -> R.drawable.dice6
        }
        binding?.dice2?.setImageResource(drawableResource2)

        binding?.floatingActionButton?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_INTENT, "voce é sortudo!")
                setPackage("com.whatsapp")
                type = "text/plain"
            }

            activity?.packageManager?.run {
                if (intent.resolveActivity(this) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        context,
                        getString(R.string.whatsapp_error),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

}
