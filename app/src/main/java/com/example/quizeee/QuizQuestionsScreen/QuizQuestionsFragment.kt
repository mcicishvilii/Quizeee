package com.example.quizeee.QuizQuestionsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizeee.MainActivity
import com.example.quizeee.Questions
import com.example.quizeee.QuizQuestionsAdapter
import com.example.quizeee.databinding.LayoutQuestionsBinding

class QuizQuestionsFragment : Fragment() {


    private val binding get() = _binding!!
    private var _binding: LayoutQuestionsBinding? = null
    private lateinit var quizQuestionsAdapter: QuizQuestionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rvQuestions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val question = requireArguments().getParcelable<Questions>(KEY_QUESTIOS)

        binding.TWQuestion.text = question?.questionText

        binding.TWPages.text = "${question?.pageNum}/6"

        quizQuestionsAdapter = QuizQuestionsAdapter()




        binding.rvQuestions.adapter = quizQuestionsAdapter

        quizQuestionsAdapter.updateAll(question!!.answers)

        binding.nextButton.setOnClickListener {
            (requireActivity() as MainActivity).onNextClicked(
                question.pageNum,
                quizQuestionsAdapter.hasClickedCorrectAnswer
            )
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val KEY_QUESTIOS = "KEY_QUESTIOS"
        fun newInstance(question: Questions): QuizQuestionsFragment {
            return QuizQuestionsFragment().apply {
                arguments = bundleOf(KEY_QUESTIOS to question)
            }
        }
    }
}






