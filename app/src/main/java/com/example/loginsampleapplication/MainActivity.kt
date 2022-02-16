package com.example.loginsampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by viewModels()

        val bt = findViewById<Button>(R.id.button)
        val tv = findViewById<TextView>(R.id.tv)

        bt.setOnClickListener { viewModel.add() }
        viewModel.num.observe(this) {
            tv.text = viewModel.num.value.toString()
        }
    }
}