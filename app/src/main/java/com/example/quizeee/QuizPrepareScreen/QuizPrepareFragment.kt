package com.example.quizeee.QuizPrepareScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizeee.QuizQuestionsScreen.QuizQuestionsFragment
import com.example.quizeee.QuizStartScreen.StartScreenFragment
import com.example.quizeee.R
import com.example.quizeee.databinding.FragmentQuizPrepareBinding

class QuizPrepareFragment:Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentQuizPrepareBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizPrepareBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bntStartgame.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, QuizQuestionsFragment())
                addToBackStack(QuizQuestionsFragment::javaClass.name)
                commit()
            }
        }
    }






    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}