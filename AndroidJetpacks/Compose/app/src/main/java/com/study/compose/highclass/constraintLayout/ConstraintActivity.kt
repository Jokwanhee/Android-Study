package com.study.compose.highclass.constraintLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.study.compose.R
import com.study.compose.ui.theme.ComposeTheme

class ConstraintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                ConstraintEx4()
            }
        }
    }
}

// 기본적으로 constraintLayout 을 구성하는 방법을 알아보자.
/*
* 제약을 걸어 줄 레퍼런스를 만든 뒤 그 레퍼런스에 제약을 걸어 화면을 구성해보자.
* */
@Composable
fun ConstraintEx1(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // reference 함수 사용하기 Ref 와 Refs 로 나뉜다.
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        // 해당 박스가 어디에 위치해야하는 지 렌더링 해주는 함수 constrainAs
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    // 앵커를 가져와서 사용한다. top, bottom, start, end
                    // linkTo 메서드를 불러와서 진행할 수 있다.
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        ) {
            
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    // 마지막 매개변수로 오는 후행 람다를 실행
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {}

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                    // 가운데 정렬을 모두 연결하는 것은 번거러움
                    // 대신해서 centerTo 사용가능
                    // 추가적으로 vertically 와 horizontally 도 진행가능하다.
                    centerTo(parent)
                    centerVerticallyTo()
                    centerHorizontallyTo()
                }
        ) {}

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(magentaBox.bottom)
                    start.linkTo(magentaBox.end)
                }
        ) {}
    }
}

@Composable
fun ConstraintEx2(){
    // ConstraintLayout 을 사용할 때, Ref 변수를 사용하여 진행하였는데,
    // ConstraintSet 으로 진행할 수 있다.
    val constraintSet = ConstraintSet(){
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        // 내부에서 constrain 을 사용하여 제약을 줄 수 있다.
        constrain(redBox){
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }
        constrain(magentaBox){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(greenBox){
            centerTo(parent)
        }
        constrain(yellowBox){
            top.linkTo(magentaBox.bottom)
            start.linkTo(magentaBox.end)
        }
    }
    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        ) {}
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("magentaBox")
        ) {}
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("greenBox")
        ) {}
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("yellowBox")
        ) {}
    }
}


// chain, barrier
@Composable
fun ConstraintEx3(){
    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        ) {}
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        ) {}
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 20.dp)
                }
        ) {}

        // 수직으로 요소들을 체이닝할 수 있다.
//        createVerticalChain(redBox, yellowBox, magentaBox)
        // 수평으로 요소들을 체이닝할 수 있다.
//        createHorizontalChain(redBox, yellowBox, magentaBox)
        // 위 메서드는 vararg 로 가변 매개변수를 갖고 있기 때문에 몇개든 체이닝할 수 있다.
        // chainStyle Spread, Packed, SpreadInside
        createHorizontalChain(redBox, yellowBox, magentaBox,
        chainStyle = ChainStyle.SpreadInside)
        createVerticalChain()

        // barrier 를 이용하여 컨테이너를 위치를 두고 원하는 view의 위치를 지정할 수 있다.
        // 아래처럼 베리어 설정 시 bottomBarrier 를 두어서 컨테이너의 아래 위치의 베리어를 만든다.
        // 위를 원한다면 topBarrier 를 설정해주면 된다.
        val barrier = createBottomBarrier(redBox, yellowBox, magentaBox)
        createEndBarrier()
        createStartBarrier()
        createTopBarrier()
        Text(
            text = "안녕하세요. 저는 조관희라고 합니다.",
            modifier = Modifier.constrainAs(text){
                top.linkTo(barrier)
            }
        )

    }
}

// Constraint 활용
@Composable
fun ConstraintEx4(){
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 8.dp
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (profileImage, author, description) = createRefs()

            AsyncImage(
                model = R.drawable.a1,
                contentDescription = "a1",
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = Color.Red),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
            )
            Text(
                text = "작가",
                modifier = Modifier.constrainAs(author){
                    linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = "설명서 설명서 설명서 설명서 설명서 설명서 설명서 설명서 설명서",
                modifier = Modifier.constrainAs(description){
                    linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )

            val chain = createVerticalChain(
                author,
                description,
                chainStyle = ChainStyle.Packed
            )

            constrain(chain){
                top.linkTo(parent.top, margin = 8.dp)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ConstraintPreview(){
    ConstraintEx4()
}