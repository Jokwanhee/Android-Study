package com.study.compose.component.TopAppBar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.study.compose.ui.theme.ComposeTheme

class TopAppBarTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                TopAppBarEx()
            }
        }
    }
}

@Composable
fun TopAppBarEx(){
    Column {
        TopAppBar(
            title = { Text("TopAppBar")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                        contentDescription = "계정"
                    )
                }
            }
        )

        // 해당 TopAppBar 는 커스텀하게 직접 ui 를 수정해야 한다.
        TopAppBar {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                    contentDescription = "업 네비게이션"
                )
            }
            Text("TopAppBar", modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                    contentDescription = "검색"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                    contentDescription = "설정"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    // 접근성을 위해서 contentDescription 작성하는 것이 옳다.
                    contentDescription = "계정"
                )
            }
        }

        Text(text = "Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    TopAppBarEx()
}