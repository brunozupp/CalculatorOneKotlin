package com.example.calculatoronekotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatoronekotlin.ui.theme.CalculatorOneKotlinTheme

class MainActivity : ComponentActivity() {

    private lateinit var txtResult: TextView

    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button

    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    private lateinit var btnClear: Button
    private lateinit var btnEquals: Button

    private var currentOperand: Double = 0.0

    private var currentOperator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResult = findViewById(R.id.txt_result)

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivide = findViewById(R.id.btn_divide)

        btnClear = findViewById(R.id.btn_clear)
        btnEquals = findViewById(R.id.btn_equals)

        btn0.setOnClickListener { numberClick("0") }
        btn1.setOnClickListener { numberClick("1") }
        btn2.setOnClickListener { numberClick("2") }
        btn3.setOnClickListener { numberClick("3") }
        btn4.setOnClickListener { numberClick("4") }
        btn5.setOnClickListener { numberClick("5") }
        btn6.setOnClickListener { numberClick("6") }
        btn7.setOnClickListener { numberClick("7") }
        btn8.setOnClickListener { numberClick("8") }
        btn9.setOnClickListener { numberClick("9") }

        btnPlus.setOnClickListener { operatorClick("+") }
        btnMinus.setOnClickListener { operatorClick("-") }
        btnMultiply.setOnClickListener { operatorClick("*") }
        btnDivide.setOnClickListener { operatorClick("/") }

        btnEquals.setOnClickListener { calculateResult() }

        btnClear.setOnClickListener { clear() }
    }

    private fun numberClick(number: String) {
        val currentText = txtResult.text.toString()
        txtResult.text = currentText + number
    }

    private fun operatorClick(operator: String) {
        currentOperator = operator
        currentOperand = txtResult.text.toString().toDouble()
        txtResult.text = ""
    }

    private fun calculateResult() {

        val operand2 = txtResult.text.toString().toDouble()

        var result = 0.0

        when(currentOperator) {
            "+" -> result = currentOperand + operand2
            "-" -> result = currentOperand - operand2
            "*" -> result = currentOperand * operand2
            "/" -> result = currentOperand / operand2
        }

        txtResult.text = result.toString()
    }

    private fun clear() {
        txtResult.text = ""
        currentOperand = 0.0
        currentOperator = ""
    }
}
