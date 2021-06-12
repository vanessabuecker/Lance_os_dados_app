package com.vbuecker.app_dice_play_devventure

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.FragmentRegisterUserBinding


class RegisterUserFragment : Fragment() {

/*    var binding: FragmentRegisterUserBinding? = null
    @SuppressLint("EditTextCommits")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val usernameCached = getUsername()
        usernameCached?.let { goUserActivity(usernameCached) }

        val edit_text_input_name = binding?.editTextInputName

        binding?.buttonSpecial?.setOnClickListener {
            val name = binding?.editTextInputName?.text
            val nameString = name.toString().trim()
            if (nameString == "") {
                Toast.makeText(
                    context,
                    R.string.toast_type_your_name,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                saveUsername(nameString)
                goUserActivity(nameString)
            }
        }

        binding?.buttonSpecial?.setOnClickListener {
            val player = edit_text_input_name?.text.toString()
            val intent = Intent(this, SpecialActivity::class.java)
            intent.putExtra("username", player)
            startActivity(intent)
        }
        return binding?.root
    }

    private fun getUsername(): String? {
        val sharedPref =
            context?.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE) ?: return null
        return sharedPref.getString("username", null)
    }

    private fun saveUsername(username: String) {
        val sharedPref =
            context?.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("username", username)
            commit()
        }
    }

    private fun goUserActivity(username: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Username", username)
        startActivity(intent)
    }*/

}

