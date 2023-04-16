package com.study.compose.component.TextField

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme

class TextFieldTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                TestFieldEx()
            }
        }
    }
}

@Composable
fun TestFieldEx(){
    var name by remember {
        mutableStateOf("Jo")
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = name,
            label = {
                    Text("이름")
            },
            onValueChange = {name = it}
        )
        OutlinedTextField(
            value = name,
            label = {
                Text("이름")
            },
            onValueChange = {name = it}
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun TestFieldPreview(){
    TestFieldEx()
}