package com.study.compose.component.Button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme
import java.lang.reflect.Modifier

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                ButtonExample(onButtonClicked = {
                    Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit){
//    Button(onClick = onButtonClicked) {
//        Text(text = "Send")
//    }
//    Button(onClick = onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Text(text = "Send")
//    }
//    Button(onClick = onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = androidx.compose.ui.Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Send")
//    }
//    Button(
//        onClick = onButtonClicked,
//        enabled = false
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = androidx.compose.ui.Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Send")
//    }
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(3.dp, Color.Magenta)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = androidx.compose.ui.Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Send")
//    }
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(3.dp, Color.Magenta),
//        shape = CircleShape
////        shape = RoundedCornerShape(10.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = androidx.compose.ui.Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Send")
//    }
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(3.dp, Color.Magenta),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
//        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = androidx.compose.ui.Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Send")
    }
}

@Preview
@Composable
fun ButtonPreview(){
    ButtonExample({})
}

