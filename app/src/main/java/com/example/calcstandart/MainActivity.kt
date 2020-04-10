package com.example.calcstandart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.button.*
import kotlinx.android.synthetic.main.input_layout.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne.setOnClickListener{appendOnExpression( string = "1",canClear = true)}
        buttonTwo.setOnClickListener{appendOnExpression( string = "2",canClear = true)}
        buttonThree.setOnClickListener{appendOnExpression( string = "3",canClear = true)}
        buttonFour.setOnClickListener{appendOnExpression( string = "4",canClear = true)}
        buttonFive.setOnClickListener{appendOnExpression( string = "5",canClear = true)}
        buttonSix.setOnClickListener{appendOnExpression( string = "6",canClear = true)}
        buttonSeven.setOnClickListener{appendOnExpression( string = "7",canClear = true)}
        buttonEight.setOnClickListener{appendOnExpression( string = "8",canClear = true)}
        buttonNine.setOnClickListener{appendOnExpression( string = "9",canClear = true)}
        buttonZero.setOnClickListener{appendOnExpression( string = "0",canClear = true)}
        buttonDot.setOnClickListener{appendOnExpression( string = ".",canClear = true)}

        buttonAddition.setOnClickListener{appendOnExpression( string = "+",canClear = false)}
        buttonSubtraction.setOnClickListener{appendOnExpression( string = "-",canClear = false)}
        buttonDivision.setOnClickListener{appendOnExpression( string = "/",canClear = false)}
        buttonMultiplication.setOnClickListener{appendOnExpression( string = "*",canClear = false)}

        buttonDeleteAll.setOnClickListener {
            textViewShowSolution.text=""
            textViewEnterNow.text=""
        }

        buttonDeleteOne.setOnClickListener {
            val string = textViewEnterNow.text.toString()
            if(string.isNotEmpty()){
                textViewEnterNow.text = string.substring(0,string.length-1)
            }
            textViewShowSolution.text=""
        }

        buttonEqual.setOnClickListener {
            val text = textViewEnterNow.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                textViewShowSolution.text = longResult.toString()
            } else {
                textViewShowSolution.text = result.toString()
            }
        }

    }

    fun appendOnExpression( string: String, canClear: Boolean)
    {
        if(canClear){
            textViewShowSolution.text = ""
            textViewEnterNow.append(string)
        }
        else
        {
            textViewEnterNow.append(textViewShowSolution.text)
            textViewEnterNow.append(string)
            textViewShowSolution.text = ""
        }

    }
}
