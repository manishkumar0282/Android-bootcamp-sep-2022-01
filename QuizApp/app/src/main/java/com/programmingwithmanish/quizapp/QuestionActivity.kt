package com.programmingwithmanish.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var tvQuestion: TextView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var tvProgress: TextView? = null
    private var btnSubmit: Button? = null
    private var progressBar: ProgressBar? = null
    private var mQuestionNumber = 1
    private var mQuestions: ArrayList<QuizQuestion>? = null
    private var mSelectedAnswer: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestions = Constants.getQuestions()

        tvQuestion = findViewById(R.id.tv_question)
        btnSubmit = findViewById(R.id.btn_submit)
        tvOption1 = findViewById(R.id.tv_op1)
        tvOption2 = findViewById(R.id.tv_op2)
        tvOption3 = findViewById(R.id.tv_op3)
        tvOption4 = findViewById(R.id.tv_op4)
        tvProgress = findViewById(R.id.tv_progress)
        progressBar = findViewById(R.id.progress_bar)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()
    }

    override fun onClick(view: View) {

        // all view transitions/ transformations will start from this function
        when(view.id) {

            R.id.tv_op1 -> {
                tvOption1?.let {
                    selectedOption(it, 1)
                }
            }
            R.id.tv_op2 -> {
                tvOption2?.let {
                    selectedOption(it, 2)
                }            }
            R.id.tv_op3 -> {
                tvOption3?.let {
                    selectedOption(it, 3)
                }            }
            R.id.tv_op4 -> {
                tvOption4?.let {
                    selectedOption(it, 4)
                }            }
            R.id.btn_submit -> {
                if(mSelectedAnswer == 0) {
                    mQuestionNumber++
                    when{
                        mQuestionNumber <= mQuestions!!.size -> {
                            setQuestion()
                        } else -> {
                            btnSubmit?.text = "Show Result"
                            val intent = Intent(this, ResultView::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestions!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            startActivity(intent)
                        }
                    }
                } else {
                    val ques = mQuestions!![mQuestionNumber-1]
                    if (ques.correctOption != mSelectedAnswer) {
                        paintSelectedAnswer(mSelectedAnswer, R.drawable.wrong_option_bg)
                    } else  {
                        mCorrectAnswers++
                        paintSelectedAnswer(mSelectedAnswer, R.drawable.correct_option_bg)
                    }

                    if(mQuestionNumber == mQuestions!!.size) {
                        btnSubmit?.text = "Show Result"
                    } else {
                        btnSubmit?.text = "Next"
                    }

                    mSelectedAnswer = 0
                }
            }
        }
    }

    private fun paintSelectedAnswer(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                        this@QuestionActivity, drawableView)
            }
            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this@QuestionActivity, drawableView)
            }
            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this@QuestionActivity, drawableView)
            }
            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this@QuestionActivity, drawableView)
            }
        }
    }

    private fun selectedOption(textViewOption: TextView, selectedOption: Int) {

        setDefaultBackground()

        mSelectedAnswer = selectedOption

        textViewOption.setTextColor(Color.parseColor("#00005C"))
        textViewOption.setTypeface(textViewOption.typeface, Typeface.BOLD)
        textViewOption.background = ContextCompat.getDrawable(
            this@QuestionActivity, R.drawable.selected_option_bg
        )
    }

    private fun setDefaultBackground() {
        val optionTextViews = ArrayList<TextView>()
        tvOption1?.let {
            optionTextViews.add(0, it)
        }
        tvOption2?.let {
            optionTextViews.add(1, it)
        }
        tvOption3?.let {
            optionTextViews.add(2, it)
        }
        tvOption4?.let {
            optionTextViews.add(3, it)
        }

        for(optionView in optionTextViews) {
            optionView.typeface = Typeface.DEFAULT
            optionView.setTextColor(Color.parseColor("#7743DB"))
            optionView.background = ContextCompat.getDrawable(
                this@QuestionActivity, R.drawable.default_option_bg
            )
        }
    }

    private fun setQuestion() {
        val ques: QuizQuestion = mQuestions!![mQuestionNumber-1];
        setDefaultBackground()
        btnSubmit?.text = "Submit"
        tvQuestion?.text = ques.question
        tvOption1?.text = ques.option1
        tvOption2?.text = ques.option2
        tvOption3?.text = ques.option3
        tvOption4?.text = ques.option4
        tvProgress?.text = "$mQuestionNumber" + "/" +progressBar?.max
        progressBar?.progress = mQuestionNumber
    }
}