package com.study.compose.component.Surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme

class SurfaceTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           ComposeTheme {
               getSurface("JO")
           }
        }
    }
}

@Composable
fun getSurface(name:String){
    androidx.compose.material.Surface(
        border = BorderStroke(width =10.dp,  color= Color.Magenta),
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp
    ) {
        Text(
            text = "Hello $name",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun testSurface(){
    getSurface("JO")
}