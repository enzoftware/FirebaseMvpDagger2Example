package com.upc.monitoringwalkers.common

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.upc.monitoringwalkers.R

fun showGeneralError(context: Context) {
    AlertDialog.Builder(context)
        .setTitle(context.resources.getString(R.string.error_title))
        .setMessage(context.resources.getString(R.string.error_message))
        .setPositiveButton(context.resources.getString(R.string.accept_button_text))
        { dialog, _ -> dialog.dismiss() }
        .show()
}

fun shortToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun longToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}