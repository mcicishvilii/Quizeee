package com.example.quizeee

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizeee.databinding.LayoutAnswerItemBinding
import kotlinx.android.parcel.Parcelize

class QuizQuestionsAdapter() :
    RecyclerView.Adapter<QuestionsViewHolder>() {

    val answerList = mutableListOf<Answer>()

    var hasClickedCorrectAnswer = false

    fun updateAll(answers: List<Answer>) {
        answerList.clear()
        answerList.addAll(answers)
        notifyDataSetChanged()
    }

    var hasCorrectAnswer = false
    private lateinit var itemClickListener: (Answer, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val binding =
            LayoutAnswerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionsViewHolder(binding)
    }

    fun setOnItemCLickListener(clickListener: (Answer, Int) -> Unit) {
        itemClickListener = clickListener
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val answer = answerList[position]
        holder.binding.answer4.text = answer.answerText

        holder.binding.answer4.setOnClickListener {

            hasCorrectAnswer = answer.isCorrect
            holder.binding.answer4.isSelected = answer.isCorrect

        }

    }

    override fun getItemCount(): Int {
        return answerList.size
    }
}

@Parcelize
data class Questions(
    val questionText: String,
    val answers: List<Answer>,
    val pageNum: Int,
) : Parcelable

@Parcelize
data class Answer(
    val answerText: String,
    val isCorrect: Boolean
) : Parcelable

class QuestionsViewHolder(val binding: LayoutAnswerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
}