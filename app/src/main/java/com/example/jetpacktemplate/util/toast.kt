package com.example.jetpacktemplate.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun View.snackbar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()

fun SoloSnackbar(view: View): (String) -> Unit = { msg: String -> view.snackbar(msg) }

