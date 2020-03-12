package com.cyogere.nav_ctrl_1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cyogere.nav_ctrl_1.databinding.FragmentGameOverBinding


class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)

        binding.playAgainButton.setOnClickListener{ v: View ->
            //v.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment) // Old way without safeArgs gradle lib
            v.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        return binding.root

    }


}
