package com.openinapp.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getDayNameFromDate(dateString: String): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = dateFormat.parse(dateString)

    val dayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault())
    return (date?.let { dayOfWeek.format(it) } ?: "Monday").substring(0..2)
}

fun getFormatDate(inputDate: String, format: String = "MMM dd"): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat(format, Locale.getDefault())

    return try {
        val date = inputFormat.parse(inputDate)
        outputFormat.format(date ?: Date())
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun calculateSteps(min: Int, max: Int, numSteps: Int): List<Int> {
    require(numSteps > 0) { "Number of steps must be greater than 0" }

    val stepSize = (max - min) / numSteps
    return List(numSteps) { min + it * stepSize }
}

fun copyToClipboard(text: String, context: Context) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip: ClipData = ClipData.newPlainText("openinapp link", text)
    clipboard.setPrimaryClip(clip)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}