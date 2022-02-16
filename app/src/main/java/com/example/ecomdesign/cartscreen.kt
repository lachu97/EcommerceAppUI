package com.example.ecomdesign

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.absoluteValue

@Composable
fun carttop() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(26.dp)
        )
        Text(
            text = "My Cart",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp
        )
        Icon(
            Icons.Filled.Delete,
            contentDescription = null,
            modifier = Modifier.size(26.dp)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun cartcard(
    name: String,
    price: String
) {
    var result = mutableStateOf(1)
    Card(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth(), elevation = 5.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = colorResource(id = R.color.colorcard)
        ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .padding(5.dp)
                .drawBehind {
                    drawCircle(color = Color.Cyan, radius = 60f, alpha = 0.5f)
                }) {
                Image (
                    painter = painterResource(id = R.drawable.myshoe),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center)
                )
            }
            Column(
                modifier = Modifier
                    .padding(15.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name, fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 21.sp,
                    color = colorResource(id = R.color.textcolor)
                )
                Text(
                    text = price, fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 21.sp,
                    color = colorResource(id = R.color.textcolor)
                )

            }
            Column(
                modifier = Modifier
                    .padding(5.dp),
            ) {

                Button(onClick = { if (result.value > 0) result.value.minus(1) }) {
                    Icon(
                        Icons.Filled.KeyboardArrowUp, contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    text = result.value.toString(),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Button(onClick = { result.value.plus(1)}) {
                    Icon(
                        Icons.Filled.Add, contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }

        }
    }
}
