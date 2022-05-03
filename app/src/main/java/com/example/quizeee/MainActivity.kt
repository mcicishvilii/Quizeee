package com.example.quizeee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.example.quizeee.CongratsScreen.CongratsFragment
import com.example.quizeee.QuizQuestionsScreen.QuizQuestionsFragment
import com.example.quizeee.QuizStartScreen.StartScreenFragment
import com.example.quizeee.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var currentScore = 0
    private val questionsList = listOf(
        Questions(
            "რომელი მეთოდი ანაცვლებს ფრაგმენტებს",
            listOf(
                Answer("Replace", true),
                Answer("Commit", false),
                Answer("Add", false),
                Answer("addToBackStack", false)
            ),
            1,
        ),
        Questions(
            "როგორ უნდა მივწვდეთ fragmentManager ს ფრაგმენტში",
            listOf(
                Answer("Replace", true),
                Answer("Commit", false),
                Answer("Add", false),
                Answer("addToBackStack", false)
            ),
            2
        )
    )

    fun onNextClicked(page: Int, isCorrect: Boolean) {
        if (isCorrect){
            currentScore++
        }
        val nextQuestion = questionsList.find {
            it.pageNum == page + 1
        }

        if (nextQuestion != null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, QuizQuestionsFragment.newInstance(nextQuestion))
                addToBackStack(StartScreenFragment::javaClass.name)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, CongratsFragment())
                addToBackStack(StartScreenFragment::javaClass.name)
                commit()
            }

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent, StartScreenFragment())
            addToBackStack(StartScreenFragment::javaClass.name)
            commit()
        }
    }
}



