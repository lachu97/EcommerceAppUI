package com.example.ecomdesign.homeui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdesign.R


@Composable
fun toppart() {
    Row(
        modifier = Modifier
            .padding(paddingval)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.dots),
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
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_search_24),
            contentDescription = "noti",
            tint = Color.Black,
            modifier = Modifier
                .padding(1.dp)
                .size(iconsize.dp)
        )

    }
}

@Composable
fun titlepart() {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(paddingval)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Our Products",
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        )
        Box {
            Text(
                text = "Sort By", fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.clickable {
                    expanded = true
                },
                fontFamily = FontFamily.SansSerif
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                    Text("Refresh")
                }
                DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                    Text("Settings")
                }
                DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                    Text("Send Feedback")
                }
            }


        }

    }
}

@Composable
fun Chippart(name: String, id: Int) {
    Card(
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {


            Icon(
                painter = painterResource(
                    id =
                    when (id) {
                        1 -> {
                            R.drawable.sneakers
                        }
                        2 -> {
                            R.drawable.watch
                        }
                        3 -> {
                            R.drawable.bag
                        }
                        else -> {
                            R.drawable.watch
                        }
                    }
                ), contentDescription = null,
                modifier = Modifier
                    .size(iconsize.dp)
                    .padding(start = 5.dp, end = 5.dp)
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = name, fontSize = 14.sp, fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Composable
fun Chipgrp() {
    val mycards = listOf<cards>(
        cards(1, "Sneakers"),
        cards(2, "Watches"),
        cards(3, "Bags"),
    )
    LazyRow(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
    ) {
        itemsIndexed(mycards) { _, it ->
            Chippart(name = it.name, id = it.id)
        }
    }
}

//display cards
@Composable
fun productcards(onclick: () -> Unit) {
    val newiconsize = 84
    Surface(
        modifier = Modifier
            .width(194.dp)
            .height(240.dp)
            .padding(paddingval),
        elevation = 10.dp,
        shape = RoundedCornerShape(cornerradius.dp)
    ) {
        Card(
            Modifier
                .fillMaxSize()
                .padding(1.dp)
                .clickable {
                    onclick
                },
            backgroundColor = colorResource(id = R.color.mywhite),
            shape = RoundedCornerShape(cornerradius.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(1.dp),
                verticalArrangement = Arrangement.spacedBy(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                cardtop()
                Spacer(modifier = Modifier.padding(5.dp))
                cardmiddle()

            }
        }
    }
}

@Composable
fun cardtop(
    state: Boolean = true
) {
    var mystate = remember { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (state) {
            Icon(
                painter = painterResource(id = R.drawable.discount), contentDescription = null,
                modifier = Modifier.size(iconsize.dp)
            )
        }

        Image(painter = painterResource(
            id = if (mystate.value) {
                R.drawable.heart
            } else {
                R.drawable.love
            }
        ),
            contentDescription = null,
            modifier = Modifier
                .size(iconsize.dp)
                .clip(CircleShape)
                .clickable {
                    mystate.value = !mystate.value
                })

    }
}

@Composable
fun cardmiddle() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.Cyan,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = size.minDimension / 4
            )
        }
        Image(
            painter = painterResource(id = R.drawable.shoe12)
            , contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(74.dp)
        )
    }


}