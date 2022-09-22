package com.example.countvisitors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize an integer counter to count the number of visitors
        var countOfVisitors = 0

        // Handle for the Text view
        val visitCountControl = findViewById<TextView>(R.id.visitCount)

        //set text on the text view
        visitCountControl.text = countOfVisitors.toString() /// "value" "0" "1"

        //handle for the button
        val btnClickMe = findViewById<Button>(R.id.clickMe)

        // Logic to be performed when the button is clicked
        btnClickMe.setOnClickListener {
            /*

             1 -> countOfVisitor = countOfVisitors + 1 = 0 + 1 = 1
             2 -> countOfVisitor = countOfVisitors + 1 = 1 + 1 = 2
             3 -> countOfVisitor = countOfVisitors + 1 = 2 + 1 = 3

             */
            countOfVisitors = countOfVisitors + 1
            // 1 2 3 4 5 6 7 8 9 10
            // toString() ===> "1" "2" "3"
            visitCountControl.text = countOfVisitors.toString()
        }
    }
}