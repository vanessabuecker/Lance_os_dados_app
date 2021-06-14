package com.vbuecker.app_dice_play_devventure

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.FragmentDiceRollSpecialBinding
import java.util.*

class DiceRollSpecialFragment : Fragment() {

    private var binding: FragmentDiceRollSpecialBinding? = null
    private lateinit var special_dice1: ImageView
    private lateinit var special_dice2: ImageView
    private lateinit var animation: Animation
    private val diceImages: MutableList<Int> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDiceRollSpecialBinding.inflate(inflater, container, false)

        special_dice1 = binding?.specialDice1!!
        special_dice2 = binding?.specialDice2!!
        val button = binding?.buttonPlay

        var playerName = arguments?.getString("playerName") ?: ""
        arguments?.getString("playerName")

        if (playerName.isBlank()) {
            playerName = "Jogador"
        }
        binding?.textViewTitle?.text = getString(R.string.welcome, playerName)

        button?.setOnClickListener {
            getRandomValue()
        }
        diceImages.add(R.drawable.specialdice1)
        diceImages.add(R.drawable.specialdice2)
        diceImages.add(R.drawable.specialdice3)
        diceImages.add(R.drawable.specialdice4)
        diceImages.add(R.drawable.specialdice5)
        diceImages.add(R.drawable.specialdice6)
        diceImages.add(R.drawable.specialdice7)
        diceImages.add(R.drawable.specialdice8)

        animation = AnimationUtils.loadAnimation(context, R.anim.dice_anim)

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

        return binding?.root
    }

    private fun getRandomValue() {
        val random = Random().nextInt(8)

        special_dice1.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                special_dice1.setImageResource(diceImages.elementAt(random))
            }

            override fun onAnimationStart(p0: Animation?) {
                special_dice1.setImageResource(R.drawable.specialdice1)

                diceImages.add(R.drawable.specialdice1)
                diceImages.add(R.drawable.specialdice2)
                diceImages.add(R.drawable.specialdice3)
                diceImages.add(R.drawable.specialdice4)
                diceImages.add(R.drawable.specialdice5)
                diceImages.add(R.drawable.specialdice6)
                diceImages.add(R.drawable.specialdice7)
                diceImages.add(R.drawable.specialdice8)

                animation = AnimationUtils.loadAnimation(context, R.anim.dice_anim)

                val random2 = Random().nextInt(8)

                special_dice2.startAnimation(animation)
                animation.setAnimationListener(object : Animation.AnimationListener {

                    override fun onAnimationRepeat(p0: Animation?) {
                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        special_dice2.setImageResource(diceImages.elementAt(random2))
                    }

                    override fun onAnimationStart(p0: Animation?) {
                        special_dice2.setImageResource(R.drawable.specialdice1)
                    }
                })
            }
        })
    }

}