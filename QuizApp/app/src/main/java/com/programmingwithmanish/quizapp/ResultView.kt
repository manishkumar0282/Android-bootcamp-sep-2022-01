package com.programmingwithmanish.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultView : AppCompatActivity() {
    private var mUserName: String? = null
    private var mCorrectAnswers: String? = null
    private var mTotalQuestions: String? = null
    private var tvName: TextView? = null
    private var tvScoreMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_view)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mCorrectAnswers = intent.getStringExtra(Constants.CORRECT_ANSWERS)
        mTotalQuestions = intent.getStringExtra(Constants.TOTAL_QUESTIONS)

        var scoreMessage: String = "You scored $mCorrectAnswers out of $mTotalQuestions"

        tvScoreMessage = findViewById(R.id.tv_score)
        tvScoreMessage?.text = scoreMessage

        tvName = findViewById(R.id.tv_name)
        tvName?.text = mUserName
    }
}