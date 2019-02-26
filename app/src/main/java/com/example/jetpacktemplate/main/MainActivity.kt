package com.example.jetpacktemplate.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jetpacktemplate.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Show layout.activity_main and setup data binding.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Inflate layout.activity_main and setup data binding.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders
            .of(this)
            .get(MainViewModel::class.java)

        viewModel.title.observe(this, Observer { value ->
            value?.let {
                mainTextView.text = it
            }
        })
    }
}
