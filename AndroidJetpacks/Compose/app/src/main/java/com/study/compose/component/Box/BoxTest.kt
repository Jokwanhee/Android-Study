package com.study.compose.component.Box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme

class BoxTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           ComposeTheme {
               BoxEx()
           }
        }
    }
}

@Composable
fun BoxEx(){
//    Box(modifier = Modifier.size(100.dp)){
//        Box(modifier = Modifier
//            .size(70.dp)
//            .background(Color.Cyan)
//            .align(Alignment.CenterStart))
//        Box(modifier = Modifier
//            .size(70.dp)
//            .background(Color.Yellow)
//            .align(Alignment.BottomEnd))
//
//        Text(text = "Hello ", modifier = Modifier.align(Alignment.TopEnd))
//        Text(text = "Jetpack World!", modifier = Modifier.align(Alignment.CenterEnd))
//        Text(text = "Compose World!", modifier = Modifier.align(Alignment.TopStart))
//    }
    Box {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .align(Alignment.CenterStart))
        Box(modifier = Modifier
            .matchParentSize()
            .background(Color.Yellow)
            .align(Alignment.BottomEnd))
    }

}

@Preview
@Composable
fun BoxPre(){
    BoxEx()
}