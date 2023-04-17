package com.study.compose.component.SlotAPI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.study.compose.ui.theme.ComposeTheme

class SlotAPITest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                SlotAPIEx()
            }
        }
    }
}

@Composable
fun SlotAPIEx(){
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }
    // 마지막 인자를 람다로 받는 것 즉, slotAPI 라고 부른다.
    Column {
//        CheckBoxWithSlot(checked = checked1, text = "Text1")
//        CheckBoxWithSlot(checked = checked2, text = "Text2")

//        CheckBoxWithSlot(checked = checked1){
//            Text("Text 1", modifier = Modifier.align(Alignment.CenterVertically))
//        }
//        CheckBoxWithSlot(checked = checked2){
//            Text("Text 2")
//        }
        CheckBoxWithSlot(checked = checked1, onCheckedChanged = { checked1 = !checked1 }) {
            Text("Text 1", modifier = Modifier.align(Alignment.CenterVertically))
        }
        CheckBoxWithSlot(checked = checked2, onCheckedChanged = { checked2 = !checked2 }) {
            Text("Text 2", modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Composable
fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>, text:String,
//    checked: MutableState<Boolean>,
    checked: Boolean,
    onCheckedChanged: () -> Unit,
//    content: @Composable () -> Unit
    content: @Composable RowScope.() -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
//            checked.value = !checked.value
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
//            checked = checked.value,
//            onCheckedChange = { checked.value = it}
        )
        content()
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun SlotAPIPreview(){
    SlotAPIEx()
}