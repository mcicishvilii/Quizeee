package com.example.quizeee

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizeee.QuizQuestionsScreen.QuizQuestionsFragment
import com.example.quizeee.databinding.LayoutQuestionsBinding

class QuizQuestionsAdapter (val questionsList: MutableList<Questions>) :RecyclerView.Adapter<QuestionsViewHolder>() {

    var score:Int = 0;
    private lateinit var itemClickListener: (Questions,Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val binding =
            LayoutQuestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionsViewHolder(binding)
    }

    fun setOnItemCLickListener(clickListener: (Questions, Int) -> Unit) {
        itemClickListener = clickListener
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val question = questionsList[position]



        holder.binding.TWQuestion.text = question.questionName
        holder.binding.answer1.text = question.answer1
        holder.binding.answer2.text = question.answer2
        holder.binding.answer3.text = question.answer3
        holder.binding.answer4.text = question.answer4
        holder.binding.TWPages.text = question.pageNum.toString()


        holder.binding.answer1.setOnClickListener {
            if (holder.binding.answer1.text == question.correctAnswer) {
                holder.binding.answer1.setTextColor(Color.GREEN)
                score++
            }
        }

        holder.binding.answer2.setOnClickListener {
            if (holder.binding.answer2.text == question.correctAnswer) {
                holder.binding.answer2.setTextColor(Color.GREEN)
                score++
            }
        }

        holder.binding.answer3.setOnClickListener {
            if (holder.binding.answer3.text == question.correctAnswer) {
                holder.binding.answer3.setTextColor(Color.GREEN)
                score++
            }
        }

        holder.binding.answer4.setOnClickListener {
            if (holder.binding.answer4.text == question.correctAnswer) {
                holder.binding.answer4.setTextColor(Color.GREEN)
                score++
            }
        }


    }

    override fun getItemCount(): Int {
        return questionsList.size
    }
}

data class Questions(
    val questionName: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val pageNum: Int,
    val correctAnswer:String
)

class QuestionsViewHolder(val binding: LayoutQuestionsBinding):
    RecyclerView.ViewHolder(binding.root){
}