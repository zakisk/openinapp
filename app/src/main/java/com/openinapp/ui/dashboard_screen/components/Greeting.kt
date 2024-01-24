@file:Suppress("KotlinConstantConditions")

package com.openinapp.ui.dashboard_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.openinapp.ui.theme.LocalSpacing
import com.openinapp.ui.theme.Manatee
import java.util.Calendar

@Composable
fun Greeting() {
    Text(
        modifier = Modifier.padding(
            start = LocalSpacing.current.medium,
            top = LocalSpacing.current.large,
            bottom = LocalSpacing.current.medium
        ),
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Manatee, fontSize = 18.sp)) {
                append(greetingMessage())
            }
            append("\n")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)) {
                append("Ajay Manva 👋")
            }
        }
    )
}

fun greetingMessage(): String {
    val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val messages = listOf("Good night", "Good morning", "Good afternoon", "Good evening")
    return messages[(currentTime / 24) * 4]
}