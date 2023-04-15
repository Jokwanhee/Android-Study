package com.study.compose.component.Card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.study.compose.MainActivity
import com.study.compose.component.Card.CardTest.Companion.cardData
import com.study.compose.ui.theme.ComposeTheme

class CardTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                CardEx(cardData)
            }
        }
    }

    companion object {
        val cardData = CardData(
            imageUri = "https://imgv3.fotor.com/images/blog-cover-image/part-blurry-image.jpg",
            imageDescription = "zoom",
            author = "Jo",
            description = "Information zoom"
        )
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color.Red
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUri,
                contentScale = ContentScale.Crop,
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier.size(32.dp)
                    .clip(CircleShape)
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Column() {
                Text(
                    text = cardData.author
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = cardData.description
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    CardEx(CardTest.cardData)
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)