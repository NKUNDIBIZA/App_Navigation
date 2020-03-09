package com.cyogere.nav_ctrl_1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.cyogere.nav_ctrl_1.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val binding:FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container, false)

        // Add onclick listener for the pay button
        /*binding.clickButton.setOnClickListener{ view: View ->

            // 1) First method of navigating
            /*Navigation.findNavController(view) //find instance of the nav controller ()
                .navigate(R.id.action_titleFragment_to_gameFragment)*/

            // 2) Second method using the "navigation:navigation-ui-ktx" dependency
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }*/

            // 3) Use the Navigation onClickListner
        binding.clickButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))

        return binding.root
        }
}
