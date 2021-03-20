package com.wkk.compose.catalog.ui

import android.text.Html
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp


@Composable
fun Caption(title: String, desc: String? = null) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
        if (!desc.isNullOrEmpty()) {
            Text(
                text = desc,
                style = MaterialTheme.typography.body2
            )
        }
    }


}


@Composable
fun SubTitle(text: String) {
    Text(text = text, style = MaterialTheme.typography.subtitle1)
}

@Composable
fun H2(text: String) {
    Text(text = text, style = MaterialTheme.typography.h2)
}

@Composable
fun H3(text: String) {
    Text(text = text, style = MaterialTheme.typography.h3)
}

@Composable
fun H4(text: String) {
    Text(text = text, style = MaterialTheme.typography.h4)
}