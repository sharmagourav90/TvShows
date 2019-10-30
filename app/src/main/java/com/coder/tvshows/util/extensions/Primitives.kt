package com.coder.tvshows.util.extensions

import android.content.Context
import android.widget.Toast

fun String?.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}