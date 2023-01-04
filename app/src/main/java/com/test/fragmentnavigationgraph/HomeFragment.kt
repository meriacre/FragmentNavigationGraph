package com.test.fragmentnavigationgraph

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.test.fragmentnavigationgraph.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.btnAction.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment)}

        binding.btnSignUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_nameFragment)
        }

        return binding.root
    }

}