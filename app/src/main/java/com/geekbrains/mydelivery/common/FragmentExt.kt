package com.geekbrains.mydelivery.common

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.makeToast(text: Int) {
    Toast.makeText(context, getString(text), Toast.LENGTH_LONG).show()
}