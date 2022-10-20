package com.example.kotlinbettercalculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.sqrt

private var firstOperand: Double = 0.0
private var secondOperand: Double = 0.0
private var operation: String = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onNumbersClick(view: View) {
        if (view is Button) {
            val number = view.layout.text.toString()
            val txtView1 = findViewById<TextView>(R.id.txtView1)
            var txtNumber = txtView1.text.toString()

            if (txtNumber == "0") {
                txtNumber = ""
            }
            val finNum = txtNumber + number
            txtView1.text = finNum
        }
    }

    fun onOperationClick(view: View) {
        if (view is Button) {
            if (operation == "") {
                operation = view.layout.text.toString()
            }

            val txtView1 = findViewById<TextView>(R.id.txtView1)
            val txtView2 = findViewById<TextView>(R.id.txtView2)
            val txtView3 = findViewById<TextView>(R.id.txtView3)
            if (firstOperand != 0.0) {
                secondOperand = txtView1.text.toString().toDouble()
            } else {
                firstOperand = txtView1.text.toString().toDouble()
            }
            txtView1.text = ""

            if (secondOperand != 0.0) {
                firstOperand = operations(operation, firstOperand, secondOperand)
            }
            operation = view.layout.text.toString()
            txtView2.text = operation
            txtView3.text = firstOperand.toString()
        }

    }

    private fun operations(operation: String, firstNumber: Double, secondNumber: Double): Double {
        return when (operation) {
            "+" -> (firstNumber + secondNumber)
            "-" -> (firstNumber - secondNumber)
            "*" -> (firstNumber * secondNumber)
            } else {
                firstNumber / secondNumber
            })
            "%" -> (firstNumber / 100)
            "√" -> (sqrt(firstNumber))
            "+/-" -> (-1 * firstNumber)
        }
    }

    fun onResultClick(view: View) {
        if (view is Button) {

            val txtView1 = findViewById<TextView>(R.id.txtView1)
            val txtView2 = findViewById<TextView>(R.id.txtView2)
            val txtView3 = findViewById<TextView>(R.id.txtView3)

            if (view.layout.text.toString() != "=") {
                operation = view.layout.text.toString()
                firstOperand = txtView1.text.toString().toDouble()
            }

            secondOperand = txtView1.text.toString().toDouble()
            firstOperand = calculate(operation, firstOperand, secondOperand)

            val dec = DecimalFormat("#.0000")
            val formatted = dec.format(firstOperand).toDouble()

            txtView1.text = formatted.toString()
            firstOperand = 0.0
            secondOperand = 0.0
            operation = ""
            txtView2.text = ""
            txtView3.text = "0"

        }

    }
}