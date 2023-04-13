package com.study.compose.component.BoxWithConstraint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BoxWithConstraintTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Outer(){
    Column() {
        // 밑에 Modifier 설정 시  ㄴㄴ
//        Inner()
//        Inner(modifier = Modifier)
        Inner(modifier = Modifier
            .width(200.dp)
            .height(160.dp)
//            .widthIn(min = 100.dp)
//            .heightIn(min = 50.dp, max = 160.dp)
//            .heightIn(max = 160.dp)
        )
    }
}

@Composable
fun Inner(modifier: Modifier = Modifier){
    BoxWithConstraints(modifier = modifier) {
        if (maxHeight > 150.dp) {
            Text(
                text="꽤나 길다",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text("maxW:$maxWidth maxH:$maxHeight minW: $minWidth minH: $minHeight")
    }
}


@Preview(showBackground = true)
@Composable
fun defaultSolve(){
    Outer()
}
