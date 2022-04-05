package com.example.calcex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        validation()
    }

    private fun setTextFields(str: String) {
        val resText = findViewById<TextView>(R.id.result_text)
        val mathOp = findViewById<TextView>(R.id.math_operation)
        if (resText.text != "") {
            mathOp.text = resText.text
            resText.text = ""
        }

        mathOp.append(str)
    }

    @SuppressLint("WrongViewCast")
    fun validation() {
        val btn0 = findViewById<TextView>(R.id.btn_0)
        btn0.setOnClickListener { setTextFields("0") }
        val btn1 = findViewById<TextView>(R.id.btn_1)
        btn1.setOnClickListener { setTextFields("1") }
        val btn2 = findViewById<TextView>(R.id.btn_2)
        btn2.setOnClickListener { setTextFields("2") }
        val btn3 = findViewById<TextView>(R.id.btn_3)
        btn3.setOnClickListener { setTextFields("3") }
        val btn4 = findViewById<TextView>(R.id.btn_4)
        btn4.setOnClickListener { setTextFields("4") }
        val btn5 = findViewById<TextView>(R.id.btn_5)
        btn5.setOnClickListener { setTextFields("5") }
        val btn6 = findViewById<TextView>(R.id.btn_6)
        btn6.setOnClickListener { setTextFields("6") }
        val btn7 = findViewById<TextView>(R.id.btn_7)
        btn7.setOnClickListener { setTextFields("7") }
        val btn8 = findViewById<TextView>(R.id.btn_8)
        btn8.setOnClickListener { setTextFields("8") }
        val btn9 = findViewById<TextView>(R.id.btn_9)
        btn9.setOnClickListener { setTextFields("9") }
        val btnPoint = findViewById<TextView>(R.id.btn_point)
        btnPoint.setOnClickListener { setTextFields(".") }
        val minusBtn = findViewById<TextView>(R.id.btn_minus)
        minusBtn.setOnClickListener { setTextFields("-") }
        val plusBtn = findViewById<TextView>(R.id.btn_plus)
        plusBtn.setOnClickListener { setTextFields("+") }
        val multiplyBtn = findViewById<TextView>(R.id.btn_multiply)
        multiplyBtn.setOnClickListener { setTextFields("*") }
        val divisionBtn = findViewById<TextView>(R.id.btn_division)
        divisionBtn.setOnClickListener { setTextFields("/") }
        val bracketOpenBtn = findViewById<TextView>(R.id.open_bracket)
        bracketOpenBtn.setOnClickListener { setTextFields("(") }
        val bracketCloseBtn = findViewById<TextView>(R.id.close_bracket)
        bracketCloseBtn.setOnClickListener { setTextFields(")") }
        val clearBtn = findViewById<TextView>(R.id.clear_text)
        val mathOp = findViewById<TextView>(R.id.math_operation)
        val resText = findViewById<TextView>(R.id.result_text)
        clearBtn.setOnClickListener {
            mathOp.text = ""
            resText.text = ""
        }
        val backBtn = findViewById<TextView>(R.id.btn_back)
        backBtn.setOnClickListener {
            val str = mathOp.text.toString()
            if (str.isNotEmpty())
                mathOp.text = str.substring(0, str.length - 1)

            resText.text = ""
        }
        val equalBtn = findViewById<TextView>(R.id.btn_equal)
        equalBtn.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mathOp.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble()) {
                    resText.text = longRes.toString()
                } else {
                    resText.text = result.toString()
                }
            } catch (e: Exception) {
                Log.d("Error", "message: ${e.message}")
            }
        }
    }
}