package com.study.compose.component.Image

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.study.compose.R

class ImageTest:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageEx(){
    Column {
        Image(
            painter = painterResource(id = R.drawable.canyon),
            contentDescription = "canyon"
        )
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "settings"
        )
    }
}