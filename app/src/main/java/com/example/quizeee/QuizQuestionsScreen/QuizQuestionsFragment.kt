package com.example.quizeee.QuizQuestionsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizeee.CongratsScreen.CongratsFragment
import com.example.quizeee.LayoutQuestionsFragment.QuestionLayoutFragment
import com.example.quizeee.Questions
import com.example.quizeee.QuizQuestionsAdapter
import com.example.quizeee.R
import com.example.quizeee.databinding.FragmentQuestionsBinding

class QuizQuestionsFragment:Fragment(){


    private val binding get () = _binding!!
    private var _binding:FragmentQuestionsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rvQuestions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)



        binding.rvQuestions.adapter = QuizQuestionsAdapter(
            mutableListOf(
                Questions(
                    "რომელი მეთოდი ანაცვლებს ფრაგმენტებს",
                    "Replace",
                    "Commit",
                    "Add",
                    "addToBackStack",
                    1,
                    "Replace"
                ),
                Questions(
                    "როგორ უნდა მივწვდეთ fragmentManager ს ფრაგმენტში",
                    "fragmentManager",
                    "parentFragmentManager",
                    "supportFragmentManager",
                    "requireFragmentManager",
                    2,
                    "supportFragmentManager"
                ),
                Questions(
                    "რომელი მეთოდი იძახება ფრაგმენტში ყველაზე ადრე",
                    "onResume",
                    "onPause",
                    "onCreate",
                    "onCreateView",
                    3,
                    "onCreate"
                ),
                Questions(
                    "რომელ მეთოდში უნდა გავანულოთ binding ცვლადი",
                    "onDestroy",
                    "onDestroyView",
                    "onPause",
                    "onStop",
                    4,
                    "onDestroyView"
                ),

                )
        ).apply {
            setOnItemCLickListener { question: Questions, i: Int ->
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.flContent,
                        QuestionLayoutFragment.newInstance(question.correctAnswer)
                    )
                    addToBackStack(QuestionLayoutFragment::javaClass.name)
                    commit()

                }
            }
        }

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}






