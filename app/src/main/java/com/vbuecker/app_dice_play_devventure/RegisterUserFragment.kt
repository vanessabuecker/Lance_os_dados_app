package com.vbuecker.app_dice_play_devventure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vbuecker.app_lanamento_dados_devventure.R
import com.vbuecker.app_lanamento_dados_devventure.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {

    var binding: FragmentRegisterUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val edit_text_input_name = binding?.editTextInputName
        val button_special = binding?.buttonSpecial
        val button_next = binding?.buttonNext

        button_special?.setOnClickListener {
            val playerName = edit_text_input_name?.text.toString()
            findNavController().navigate(
                R.id.action_registerUserFragment_to_diceRollSpecialFragment,
                bundleOf(("playerName" to playerName))
            )
        }

        button_next?.setOnClickListener {
            val regularPlayer = edit_text_input_name?.text.toString()
            findNavController().navigate(
                R.id.action_registerUserFragment_to_diceRollFragment,
                bundleOf(("regularPlayer" to regularPlayer))
            )
        }

        return binding?.root
    }
}






