package com.example.jetpacktemplate.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jetpacktemplate.R
import com.example.jetpacktemplate.databinding.ActivityMainBinding
import com.example.jetpacktemplate.util.EventHandler
import com.example.jetpacktemplate.util.snackbar

/**
 * Show layout.activity_main and setup data binding.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Inflate layout.activity_main and setup data binding.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders
            .of(this)
            .get(MainViewModel::class.java)

        viewModel.title.observe(this, Observer { value ->
            value?.let {
                binding.title = it
            }
        })

        binding.handler = EventHandler(this)
    }
}
