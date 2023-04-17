package com.study.compose.component.Scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.component.CheckBox.CheckBoxEx
import com.study.compose.ui.theme.ComposeTheme

class ScaffoldTest: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                ScaffoldEx()
            }
        }
    }
}


// Slot API 를 살펴볼 수 있는 Scaffold Composable
@Composable
fun ScaffoldEx(){
    var checked by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기",
                        )
                    }
                },
                title = {
                    Text("Scaffold App")
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(8.dp)
        ) {
            CheckBoxWithContent(
                checked = checked,
                toggleState = { checked = !checked }
            ) {
               Text("Compose!!", Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}

@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {toggleState()}
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview(){
    ScaffoldEx()
}