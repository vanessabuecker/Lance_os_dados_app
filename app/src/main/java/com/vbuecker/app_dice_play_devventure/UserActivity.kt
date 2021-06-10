package com.vbuecker.app_dice_play_devventure

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    @SuppressLint("EditTextCommits")
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        val usernameCached = getUsername()
        usernameCached?.let { goUserActivity(usernameCached) }

        setContentView(binding.root)

        supportActionBar?.title = "Lance os Dados"

        val button_next = binding.buttonNext
        button_next.setOnClickListener {
            val name = binding.editTextInputName.text
            val nameString = name.toString().trim()
            if (nameString == "") {
                Toast.makeText(
                    applicationContext,
                    R.string.toast_type_your_name,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                saveUsername(nameString)
                goUserActivity(nameString)
            }
        }
    }

    private fun getUsername(): String? {
        val sharedPref =
            this.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE) ?: return null
        return sharedPref.getString("username", null)
    }

    private fun saveUsername(username: String) {
        val sharedPref =
            this.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("username", username)
            commit()
        }
    }

    private fun goUserActivity(username: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Username", username)
        startActivity(intent)
    }

}