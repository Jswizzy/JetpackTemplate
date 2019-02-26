package com.example.jetpacktemplate.util

import android.content.Context
import android.widget.Toast

open class EventHandler(private val context: Context) {
    fun onButtonClick() {
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
    }
}