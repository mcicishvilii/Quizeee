package com.example.quizeee.CongratsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizeee.databinding.FragmentCongratsBinding


class CongratsFragment: Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentCongratsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCongratsBinding.inflate(inflater, container, false)
        return binding.root
    }
}