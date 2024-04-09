package com.example.quizapp

object Constants {

    const val USER_NAME : String = "User_name"
    const val TOTAL_QUESTIONS : String = "total questions"
    const val CORRECT_ANSWERS : String = "Correct answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val ques1 = Question(
            1,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_argentina,"Argentina","Spain","Canada","Austria",1
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_australia,"United Kingdom","Australia","United Stated","New Zealand",2
        )
        questionList.add(ques2)

        val ques3 = Question(
            3,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_belgium,"Germany","Belgium","Hungary","Switzerland",2
        )
        questionList.add(ques3)

        val ques4 = Question(
            4,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_brazil,"Chile","Mexico","Brazil","South Korea",3
        )
        questionList.add(ques4)

        val ques5 = Question(
            5,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_denmark,"Spain","Sweden","Finland","Denmark",4
        )
        questionList.add(ques5)

        val ques6 = Question(
            6,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_fiji,"Lithuania","Papua New Guinea","Armenia","Fiji",4
        )
        questionList.add(ques6)

        val ques7 = Question(
            7,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_germany,"Belgium","France","Germany","Luxembourg",3
        )
        questionList.add(ques7)

        val ques8 = Question(
            8,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_india,"India","Ireland","Mexico","Italy",1
        )
        questionList.add(ques8)

        val ques9 = Question(
            9,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_usa,"Malaysia","United States","Cuba","Liberia",2
        )
        questionList.add(ques9)

        val ques10 = Question(
            10,"Which Country does this flag belong to? ",
            R.drawable.ic_flag_of_new_zealand,"Australia","United Kingdom","New Zealand","Hungary",3
        )
        questionList.add(ques10)
        return questionList
    }
}