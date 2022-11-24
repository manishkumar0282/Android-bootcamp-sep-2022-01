package com.programmingwithmanish.quizapp

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<QuizQuestion> {
        val questions = ArrayList<QuizQuestion>()

        val q1 = QuizQuestion(
            1,
            "What is the current year",
            "2001",
            "2010",
            "2020",
            "2022",
            4)

        questions.add(q1)

        val q2 = QuizQuestion(
            1,
            "What is the current month",
            "Jan",
            "Feb",
            "Nov",
            "Dec",
            3)

        questions.add(q2)

        return questions
    }
}