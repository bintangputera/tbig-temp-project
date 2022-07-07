package com.bintangpoetra.tempapp.utils

import android.content.Context
import android.widget.TextView
import com.bintangpoetra.tempapp.R

fun TextView.setStatus(context: Context, completed: Boolean) {
    if (completed) {
        text = "Completed"
        setBackgroundColor(resources.getColor(R.color.lightGreen))
        setTextColor(resources.getColor(R.color.green))
    } else {
        text = "Uncompleted"
        setBackgroundColor(resources.getColor(R.color.lightOrange))
        setTextColor(resources.getColor(R.color.orange))
    }
}