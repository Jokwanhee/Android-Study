package com.study.compose.component.CheckBox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.study.compose.ui.theme.ComposeTheme

class CheckBoxTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                CheckBoxEx()
            }
        }
    }
}

@Composable
fun CheckBoxEx(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        // delegated properties
        // checked 가 프로퍼티인 것처럼 표시가능 by 키워드
//        var checked by remember {
//            mutableStateOf(false)
//        }
//
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
        // desturction
        val (checked, setChecked) = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checked,
            onCheckedChange = {
//                setChecked(!checked)
//                setChecked(it)
            }
        )
        Text(
            text = "Are you Jo?",
            modifier = Modifier.clickable {
                setChecked(!checked)
//                checked = !checked
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview(){
    CheckBoxEx()
}