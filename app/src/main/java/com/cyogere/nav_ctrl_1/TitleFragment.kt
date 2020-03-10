package com.cyogere.nav_ctrl_1


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.cyogere.nav_ctrl_1.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val binding:FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container, false)

        // Add onclick listener for the pay button
       /* binding.clickButton.setOnClickListener{ view: View ->

            // 1) First method of navigating
            /*Navigation.findNavController(view) //find instance of the nav controller ()
                .navigate(R.id.action_titleFragment_to_gameFragment)*/

            // 2) Second method using the "navigation:navigation-ui-ktx" dependency
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }*/

            // 3) Use the Navigation onClickListner
        binding.clickButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))

        // Tell android that this fragment has menu
        setHasOptionsMenu(true)


        return binding.root
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.over_flow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)

        // If the navigation does not handle the menu item, super.onOptionsItemSelected(item) will handle it without navigating
    }
}
