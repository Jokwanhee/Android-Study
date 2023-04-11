package com.study.compose.component.Modifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                ModifierEx()
            }
        }
    }
}

@Composable
fun ModifierEx(){
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Cyan
        ),
        onClick = {},
//        enabled = false,
//        modifier = Modifier.fillMaxSize()
//        modifier = Modifier
//            .height(100.dp)
//            .width(200.dp) // 체이닝하여 진행해도 된다.

        modifier = Modifier
//            .size(200.dp, 100.dp)
            .size(200.dp)
            .padding(10.dp)
                    // button 에서는 modifier 에서 background 배경색을 변경할 수 없음
//                .background(Color.Red)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier
                .size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text(
            text = "Search",
//            modifier = Modifier.clickable {  }
            modifier = Modifier
                .offset(x = 10.dp, y = 10.dp)
                .background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun ModifierExTest(){
    ModifierEx()
}