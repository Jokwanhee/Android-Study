package com.study.compose.component.Row

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RowTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview
@Composable
fun RowEx() {
    Row(
//        horizontalArrangement = Arrangement.SpaceAround,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)
    ) {
//        Text(text = "First", modifier = Modifier.align(Alignment.Top))
//        Text(text = "Second", modifier = Modifier.align(Alignment.CenterVertically))
//        Text(text = "Third", modifier = Modifier.align(Alignment.Bottom))
        Text(
            text = "First",
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.Top)
                .weight(2f)
                .background(color = Color.Magenta)
        )
        Icon(
           imageVector = Icons.Filled.Add,
           contentDescription = "추가",
            modifier = Modifier
                .weight(2f)
                .background(Color.Cyan)
        )
        Text(
            text = "Second",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(3f)
                .background(color = Color.Red)
        )
        Text(
            text = "Third",
            modifier = Modifier.weight(2f)
        )
    }
}