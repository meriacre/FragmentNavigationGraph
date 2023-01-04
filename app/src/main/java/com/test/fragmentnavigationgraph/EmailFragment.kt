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
import com.test.fragmentnavigationgraph.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        var input = requireArguments().getString("user_name")
//        binding.textView.text = input.toString()
        binding.btnNext.setOnClickListener {
            if (!TextUtils.isEmpty(binding.etEmail.text.toString())){
                var bundle = bundleOf("user_email" to binding.etEmail.text.toString(),
                                            "user_name" to input)
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
            }
            else{
                Toast.makeText(requireContext(), "Please insert your email", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}