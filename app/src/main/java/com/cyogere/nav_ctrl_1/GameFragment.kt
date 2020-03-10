package com.cyogere.nav_ctrl_1


import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cyogere.nav_ctrl_1.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val binding:FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container,false)



        binding.submitButton.setOnClickListener{v: View ->

            var answer1: Boolean = binding.radio1.isChecked
            var answer2: Boolean = binding.radio2.isChecked
            var answer3: Boolean = binding.radio3.isChecked
            var answer4: Boolean = binding.radio4.isChecked

            if(answer1 || answer4  == true)
                v.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
            else if(answer2 || answer3  == true)
                v.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
        }



        return binding.root
        }


    }
