package com.study.compose.component.NetworkImage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter

class NetworkImageTest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilEx()
        }
    }
}


// https://imgv3.fotor.com/images/blog-cover-image/part-blurry-image.jpg
@Composable
fun CoilEx(){
    // google 에서는 rememberImagePainter 추천하나 coil 에서는 다르다.
    val painter = rememberImagePainter(data = "https://imgv3.fotor.com/images/blog-cover-image/part-blurry-image.jpg")
    Image(
        painter = painter,
        contentDescription = "zoom"
    )
    // coil AsyncImage 에서는 권장 (캐시 사용으로 효율적이다.)
    Column {
        AsyncImage(
            model = "https://imgv3.fotor.com/images/blog-cover-image/part-blurry-image.jpg",
            contentDescription = "zoom"
        )
        AsyncImage(
            model = "https://imgv3.fotor.com/images/blog-cover-image/part-blurry-image.jpg",
            contentDescription = "zoom"
        )
    }
}

// network image 를 불러올 때는 preview 지원되지 않는다.
@Preview(showBackground = true)
@Composable
fun networkImageEx(){
    CoilEx()
}