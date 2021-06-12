package com.vbuecker.app_dice_play_devventure

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.ActivitySpecialBinding
import java.util.*

class SpecialActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpecialBinding
    private lateinit var special_dice1: ImageView
    private lateinit var special_dice2: ImageView
    private lateinit var animation: Animation
    private val diceImages: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpecialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = ""
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val button = binding.buttonPlay

        val player = intent.getStringExtra("username")
        val message = resources.getString(R.string.welcome, player)
        binding.textViewTitle.text = message

        special_dice1 = binding.specialDice1
        special_dice2 = binding.specialDice2

        button.setOnClickListener {
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

        animation = AnimationUtils.loadAnimation(this@SpecialActivity, R.anim.dice_anim)
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

                animation = AnimationUtils.loadAnimation(this@SpecialActivity, R.anim.dice_anim)

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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}


