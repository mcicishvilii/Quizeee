package com.example.quizeee.QuizStartScreen

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizeee.MainActivity
import com.example.quizeee.QuizPrepareScreen.QuizPrepareFragment
import com.example.quizeee.R
import com.example.quizeee.databinding.FragmentQuizWelcomeActivityBinding

class StartScreenFragment: Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentQuizWelcomeActivityBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizWelcomeActivityBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.TVTipText.setOnClickListener {
            ( requireActivity() as MainActivity).onNextClicked(0,false )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
