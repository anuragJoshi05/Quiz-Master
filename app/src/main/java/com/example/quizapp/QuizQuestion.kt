package com.example.quizapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.graphics.Color
import android.graphics.Typeface
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var ivImage : ImageView? = null
    private var tvQuestion : TextView? = null
    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null
    private var btnSubmit : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        ivImage = findViewById(R.id.iv_image)
        tvQuestion = findViewById(R.id.tv_question)
        option1 = findViewById(R.id.tv_option_one)
        option2 = findViewById(R.id.tv_option_two)
        option3 = findViewById(R.id.tv_option_three)
        option4 = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btnSubmit)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()


        SetQuestion()

    }

    private fun SetQuestion() {
        defaultOptionsView()
//        Log.i("QuestionList size is", "${questionsList.size}")
//
//        for (i in questionsList) {
//            Log.e("Questions is", i.question)
//        }

//            var mCurrentPosition = 1

            val question: Question = mQuestionsList!![mCurrentPosition - 1]
            ivImage?.setImageResource(question.image)
            progressBar?.progress = mCurrentPosition
            tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
            tvQuestion?.text = question.question
            option1?.text = question.optionOne
            option2?.text = question.optionTwo
            option3?.text = question.optionThree
            option4?.text = question.optionFour

        if (mCurrentPosition==mQuestionsList!!.size) {
            btnSubmit?.text = getString(R.string.finish)

        }else{
            btnSubmit?.text = getString(R.string.submit)
        }
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition =selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one -> {
                option1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two -> {
                option2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three -> {
                option3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four -> {
                option4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmit -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionsList!!.size -> {
                            SetQuestion()
                        }else->{
                            val intent = Intent(this, ResultPage::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            startActivity(intent)
                            finish()


                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_default_option_border_bg)
                        answerView(question.correctAnswer,R.drawable.correct_default_option_border_bg)
                    }else {
                        mCorrectAnswers++
                        answerView(
                            mSelectedOptionPosition,
                            R.drawable.correct_default_option_border_bg
                        )
                    }


                    if(mCurrentPosition ==mQuestionsList!!.size){
                        btnSubmit?.text = getString(R.string.finish)
                    }else{
                        btnSubmit?.text= getString(R.string.next_question)
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1 -> {
                option1?.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                option2?.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                option3?.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                option4?.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}