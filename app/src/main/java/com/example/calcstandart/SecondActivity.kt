package com.example.calcstandart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    companion object {

        const val TOTAL_COUNT = "total_count"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showSolution()
    }

    fun showSolution(){
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        textSolutionSecond.text=count.toString()
    }
}
