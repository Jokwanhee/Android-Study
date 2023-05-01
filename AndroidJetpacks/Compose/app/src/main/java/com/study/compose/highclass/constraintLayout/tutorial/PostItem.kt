package com.study.compose.highclass.constraintLayout.tutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.study.compose.R

@Preview
@Composable
fun PostItem(
    modifier: Modifier = Modifier
){
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 7.dp)
    ) {
        val (
            imageAvatar,
            imgMore,
            textUserName,
            imgPost,
            imgLike,
            imgComment,
            imgShare,
            imgBookmark,
            textLikes,
            textUserNameBottom,
            textViewComments,
            imgTags
        ) = createRefs()

        val ringBrush = remember {
            Brush.sweepGradient(
                listOf(
                    Color(0xFFC913B9),
                    Color(0xFFC9373F),
                    Color(0xFFFECD00)
                )
            )
        }

        val borderWidth = 1.5.dp

        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "dog image",
            modifier = modifier
                .constrainAs(imageAvatar) {
                    start.linkTo(parent.start, 14.dp)
                    top.linkTo(parent.top, 7.dp)
                }
                .size(32.dp)
                .border(
                    border = BorderStroke(borderWidth, ringBrush),
                    shape = CircleShape
                )
                .padding(borderWidth + (borderWidth / 2))
                .clip(CircleShape)
//                .paint(
//                    painter = painterResource(id = R.drawable.ic_ring),
//                    contentScale = ContentScale.FillWidth
//                )
        )

        Image(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "more",
            modifier = modifier
                .constrainAs(imgMore){
                    end.linkTo(parent.end, 14.dp)
                    top.linkTo(imageAvatar.top)
                    bottom.linkTo(imageAvatar.bottom)
                }
        )

        Column(
            modifier = modifier
                .constrainAs(textUserName){
                    start.linkTo(imageAvatar.end, 7.dp)
                    top.linkTo(imageAvatar.top)
                    bottom.linkTo(imageAvatar.bottom)
                }
        ) {
            Text(
                text = "JoKwanhee",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            )
            Text(
                text = "bcsd",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp
                )
            )
        }

        Image(
            painter = painterResource(id = R.drawable.post_image),
            contentDescription = "post image",
            modifier = modifier
                .fillMaxWidth()
                .height(400.dp)
                .constrainAs(imgPost) {
                    start.linkTo(parent.start)
                    top.linkTo(imageAvatar.bottom, 7.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints // 제약되어진 부분을 가득 채우기
                },
            contentScale = ContentScale.Crop // 사진 사이즈에 맞게 꽉채우기
        )
        Image(
            painter = painterResource(id = R.drawable.ic_tags),
            contentDescription = "tags",
            modifier = modifier
                .constrainAs(imgTags){
                    start.linkTo(imgPost.start, 7.dp)
                    bottom.linkTo(imgPost.bottom, 7.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_liked),
            contentDescription = "like or unlike",
            modifier = modifier
                .constrainAs(imgLike){
                    top.linkTo(imgPost.bottom, 7.dp)
                    start.linkTo(parent.start, 14.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_comment),
            contentDescription = "comment",
            modifier = modifier
                .width(24.dp)
                .height(24.dp)
                .constrainAs(imgComment) {
                    top.linkTo(imgLike.top)
                    start.linkTo(imgLike.end, 10.dp)
                    bottom.linkTo(imgLike.bottom)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = "share",
            modifier = modifier
                .width(24.dp)
                .height(24.dp)
                .constrainAs(imgShare) {
                    top.linkTo(imgComment.top)
                    start.linkTo(imgComment.end, 10.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            modifier = modifier
                .width(24.dp)
                .height(24.dp)
                .constrainAs(imgBookmark) {
                    top.linkTo(imgShare.top)
                    end.linkTo(parent.end, 14.dp)
                }
        )

        Text(
            text = "100 Likes",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            ),
            modifier = modifier
                .constrainAs(textLikes){
                    start.linkTo(parent.start, 14.dp)
                    top.linkTo(imgLike.bottom, 7.dp)
                }
        )
        Text(
            text = "Username 안녕하세요 저는 조관희입니다. 저의 인스타에 방문해주셔서 감사합니다.**********************************++++++++++++++++++++++++++++++++++",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
                .constrainAs(textUserNameBottom){
                    start.linkTo(textLikes.start)
                    top.linkTo(textLikes.bottom, 7.dp)
                }
        )

        Text(
            text = "View all 16 comments",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            ),
            modifier = modifier
                .constrainAs(textViewComments){
                    start.linkTo(textUserNameBottom.start)
                    top.linkTo(textUserNameBottom.bottom, 7.dp)
                }
        )
    }
}