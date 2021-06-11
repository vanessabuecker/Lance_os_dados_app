package com.vbuecker.app_dice_play_devventure

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.ActivityMainBinding
import pl.droidsonroids.gif.GifImageView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var diceImgOne: GifImageView
    private lateinit var diceImgTwo: GifImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = ""
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val button = binding.button

        val text_view_title = binding.textViewTitle
        val share_button = binding.floatingActionButton
        val username = intent.getStringExtra("Username")
        val newTitle = getString(R.string.welcome, username)
        text_view_title.text = newTitle

        share_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Você é sortudo!")
            intent.setPackage("com.whatsapp")
            intent.type = "text/plain"
            if (intent.resolveActivity(this.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Você não possui o Whatsapp instalado", Toast.LENGTH_SHORT)
                    .show()

                // TODO: 11/06/2021 share print screen, redirect to download whatsapp
            }
        }

        val sharedPref =
            this.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit())
        {
            clear()
            commit()
        }
        diceImgOne = binding.dice1
        diceImgTwo = binding.dice2

        button.setOnClickListener {
              rollDice()
          }

          diceImgOne = binding.dice1
          diceImgTwo = binding.dice2
      }

      private fun rollDice() {
          val drawableResource = when (java.util.Random().nextInt(6) + 1) {
              1 -> R.drawable.dice1
              2 -> R.drawable.dice2
              3 -> R.drawable.dice3
              4 -> R.drawable.dice4
              5 -> R.drawable.dice5
              else
              -> R.drawable.dice6
          }
          diceImgOne.setImageResource(drawableResource)

          val drawableResource2 = when (java.util.Random().nextInt(6) + 1) {
              1 -> R.drawable.dice1
              2 -> R.drawable.dice2
              3 -> R.drawable.dice3
              4 -> R.drawable.dice4
              5 -> R.drawable.dice5
              else
              -> R.drawable.dice6
          }
          diceImgTwo.setImageResource(drawableResource2)
      }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}



