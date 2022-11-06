package com.programmingwithmanish.regularcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    private var isDotAdded: Boolean = false
    private var isLastDigit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        isLastDigit = true
    }

    fun onOperation(view: View) {
        tvInput?.text?.let {
            if (isLastDigit && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                isLastDigit = false // Update the flag
                isDotAdded = false    // Reset the DOT flag
            }
        }
    }

    fun onEqual(view: View) {
        var tvValue = tvInput?.text.toString()
        var prefix = ""

        try{
            if(tvValue.startsWith("-")) {
                // -99 --- 0=- 1=9 2=9
                // "-99"
                // 99
                prefix = "-"
                tvValue = tvValue.substring(1)
            }

            if(tvValue.contains("-")) {
                val splitValue = tvValue.split("-")
                var one = splitValue[0]
                val two = splitValue[1]
                if(prefix.isNotEmpty()) {
                    one = prefix+one
                }
                tvInput?.text = removeZeroAfterOperation((one.toDouble() - two.toDouble()).toString())
            }
            if(tvValue.contains("+")) {
                val splitValue = tvValue.split("+")
                var one = splitValue[0]
                val two = splitValue[1]
                if(prefix.isNotEmpty()) {
                    one = prefix+one
                }
                tvInput?.text = removeZeroAfterOperation((one.toDouble() + two.toDouble()).toString())
            }
            if(tvValue.contains("/")) {
                val splitValue = tvValue.split("/")
                var one = splitValue[0]
                val two = splitValue[1]
                if(prefix.isNotEmpty()) {
                    one = prefix+one
                }
                tvInput?.text = removeZeroAfterOperation((one.toDouble() / two.toDouble()).toString())
            }
            if(tvValue.contains("*")) {
                val splitValue = tvValue.split("*")
                var one = splitValue[0]
                val two = splitValue[1]
                if(prefix.isNotEmpty()) {
                    one = prefix+one
                }
                tvInput?.text = removeZeroAfterOperation((one.toDouble() * two.toDouble()).toString())
            }
        } catch(e: ArithmeticException){
            print(e.toString())
        }
    }

    private fun removeZeroAfterOperation(result: String): String {
        var value = result
        if (result.contains(".0")) {
            value = result.substring(0, result.length - 2)
        }
        // this will remove extra .0 from the end
        return value
    }

    private fun isOperatorAdded(input: String): Boolean {

        return if (input.startsWith("-")) {
            false
        } else {
            (input.contains("-") ||
                    input.contains("+") ||
                    input.contains("*") ||
                    input.contains("/"))
        }
    }

    fun onClear() {
        tvInput?.text = ""
        isDotAdded = false
        isLastDigit = false
    }

    fun onDot(view: View) {
        if(isLastDigit && !isDotAdded) {
            tvInput?.append(".")
            isDotAdded = true
            isLastDigit = false
        }
    }
}

