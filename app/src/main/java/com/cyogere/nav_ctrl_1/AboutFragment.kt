package com.cyogere.nav_ctrl_1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.cyogere.nav_ctrl_1.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentAboutBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_about, container, false)
        return binding.root
        }
    }
