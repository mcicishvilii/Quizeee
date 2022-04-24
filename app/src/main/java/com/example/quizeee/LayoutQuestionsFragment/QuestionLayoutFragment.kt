package com.example.quizeee.LayoutQuestionsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.quizeee.databinding.LayoutQuestionsBinding

class QuestionLayoutFragment: Fragment() {
    private val binding get () = _binding!!
    private var _binding: LayoutQuestionsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutQuestionsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val correctAnswerCOMP = requireArguments().getString(KEY_CORRECT_ANSWER)
        binding.answer1.text = correctAnswerCOMP

    }

    companion object {
        const val KEY_CORRECT_ANSWER = "KEY_CORRECT_ANSWER"

        fun newInstance(correctAnswer: String): QuestionLayoutFragment {
            return QuestionLayoutFragment().apply {
                arguments = bundleOf(KEY_CORRECT_ANSWER to correctAnswer)

            }
        }
    }
}

