package com.study.compose.component.Text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.compose.ui.theme.ComposeTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Greeting2(name = "jokwanhee")
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {

//    Text(color = Color.Red, text = "Hello $name!")
    // 해쉬값으로 색상 전달
//    Text(color = Color(0xffff9944), text = "Hello $name!")

    // === size ===
//    Text(color = Color.Red, text = "Hello $name!", fontSize = 30.sp)

//    Text(color = Color.Red, text = "Hello $name!", fontSize = 30.sp, fontWeight = FontWeight.Bold)

//    Text(
//        color = Color.Red,
//        text = "Hello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive
//    )

//    Text(
//        color = Color.Red,
//        text = "Hello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp
//    )

//    Text(
//        color = Color.Red,
//        text = "Hello $name!\nHello $name!\nHello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2
//    )

//    Text(
//        color = Color.Red,
//        text = "Hello $name!\nHello $name!\nHello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline
//    )

//    Text(
//        modifier = Modifier.width(300.dp),
//        color = Color.Red,
//        text = "Hello $name!\nHello $name!\nHello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline,
//        textAlign = TextAlign.Center
//    )

    Text(
        modifier = Modifier.height(300.dp),
        color = Color.Red,
        text = "Hello $name!\nHello $name!\nHello $name!",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeTheme {
        Greeting2("Android")
    }
}