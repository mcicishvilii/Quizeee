package com.example.quizeee.QuizQuestionsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.quizeee.databinding.FragmentSecondQuestionBinding

class SecondQuestionFragment: Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentSecondQuestionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondQuestionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // CO cvladis bolos aris CompanionObjectis abreviatura ro gavarchio

        val QuestionNameCO = requireArguments().getString(KEY_QUESTION_NAME)
        val answer1CO = requireArguments().getString(KEY_ANSWER1)
        val answer2CO = requireArguments().getString(KEY_ANSWER2)
        val answer3CO = requireArguments().getString(KEY_ANSWER3)
        val answer4CO = requireArguments().getString(KEY_ANSWER4)
        val pageNumbersCO = requireArguments().getInt(KEY_PAGE_NUMBERS)

        binding.TWQuestion.text = QuestionNameCO
        binding.answer1.text = answer1CO
        binding.answer2.text = answer2CO
        binding.answer3.text = answer3CO
        binding.answer4.text = answer4CO
        binding.TWPages.text = pageNumbersCO.toString()


    }




    companion object{

        const val KEY_QUESTION_NAME = "KEY_QUESTION_NAME"
        const val KEY_ANSWER1 = "KEY_ANSWER1"
        const val KEY_ANSWER2 = "KEY_ANSWER2"
        const val KEY_ANSWER3 = "KEY_ANSWER3"
        const val KEY_ANSWER4 = "KEY_ANSWER4"
        const val KEY_PAGE_NUMBERS = "KEY_PAGE_NUMBERS"


        fun newInstance(questionName: String,
                        answer1:String,
                        answer2:String,
                        answer3:String,
                        answer4:String,
                        pageNumbers:Int
                        ) :SecondQuestionFragment{
            return SecondQuestionFragment().apply {
                arguments = bundleOf(KEY_QUESTION_NAME to questionName,
                                            KEY_ANSWER1 to answer1,
                                            KEY_ANSWER2 to answer2,
                                            KEY_ANSWER3 to answer3,
                                            KEY_ANSWER4 to answer4,
                                            KEY_PAGE_NUMBERS to pageNumbers,)

            }
        }
    }
}


