package com.example.ecomdesign

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdesign.homeui.clicker
import com.example.ecomdesign.homeui.iconsize
import com.example.ecomdesign.homeui.paddingval
import androidx.compose.runtime.remember as composeRuntimeRemember

@Composable
fun toppartdeatail() {
    Row(
        modifier = Modifier
            .padding(paddingval)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            contentDescription = "noti",
            tint = Color.Black,
            modifier = Modifier
                .padding(1.dp)
                .size(iconsize.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "noti",
            tint = Color.Black,
            modifier = Modifier
                .padding(1.dp)
                .size(iconsize.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "noti",
            modifier = Modifier
                .padding(1.dp)
                .size(iconsize.dp)
        )

    }
}

@Composable
fun middleart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .drawBehind {
                drawCircle(
                    color = Color.Cyan,
                    radius = 400f,
                    center = Offset(
                        x = size.width / 2,
                        y = size.height / 2
                    )
                )
            }, verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.myshoe),
            contentDescription = null,
            modifier = Modifier
                .size(264.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun bottompartdetail(
    onclick: clicker,
    name: String = "Nike Air Flex",
    price: String = "$ 350.99",
    description: String = "Built for natural motion,the Nike Flex Shoes"
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        color = colorResource(id = R.color.colorcard),
        elevation = 2.dp
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),

            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = name, color = colorResource(id = R.color.textcolor),
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = colorResource(id = R.color.orange),
                    modifier = Modifier.size(26.dp)
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = description,
                color = colorResource(id = R.color.textcolor),
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            size(listOf("US 7", "US 6", "US 5", "US 4"))
            Spacer(modifier = Modifier.padding(5.dp))
            colorslistcard(listOf(Color.Green, Color.Cyan, Color.Blue, Color.Red))
            Spacer(modifier = Modifier.padding(5.dp))
            bottomcard(onclick)
        }
    }
}

@Composable
fun colorslistcard(colorlist: List<Color>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Available Colors", fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            fontSize = 19.sp,
            color = colorResource(id = R.color.textcolor)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        LazyRow(modifier = Modifier.padding(10.dp)) {
            itemsIndexed(colorlist) { _, clr ->
                Canvas(modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable {

                    }
                    .padding(15.dp), onDraw = {
                    drawcircles(clr = clr)
                })
            }
        }

    }
}

@Composable
fun bottomcard(click: clicker) {
    Card(
        elevation = 2.dp, backgroundColor = Color.White, shape = RoundedCornerShape(
            topStart = 25.dp, topEnd = 25.dp
        ), modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$ 259.99", fontWeight = FontWeight.Bold, fontSize = 23.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.textcolor),
                modifier = Modifier.padding(start = 5.dp)
            )
            Button(
                onClick = {
                       click.clickit()
                },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, color = colorResource(id = R.color.colorcard)),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        Icons.Filled.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = "Add to Cart",
                        color = colorResource(id = R.color.textcolor),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

fun DrawScope.drawcircles(clr: Color) {
    drawCircle(
        color = clr,
        radius = 34f,
    )

}

@Composable
fun size(sizelist: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Size", fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            fontSize = 19.sp,
            color = colorResource(id = R.color.textcolor)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        LazyRow {
            itemsIndexed(sizelist) { _, name ->
                itemcard(name = name)

            }
        }

    }
}

@Composable
fun itemcard(
    name: String,
    isclicked: MutableState<Boolean> = composeRuntimeRemember { mutableStateOf(false) },
    click: () -> Unit = {}
) {
    Card(
        backgroundColor = colorResource(id = if (isclicked.value) R.color.cardbg else R.color.colorcard),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                isclicked.value = !isclicked.value
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 1.dp
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(10.dp),
            color = Color.Black
        )
    }

}