package com.example.ecomdesign.homeui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdesign.R

val iconsize = 26
val paddingval = 10.dp

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
            .padding(10.dp)
    ) {
        Row(
            Modifier
                .padding(10.dp), verticalAlignment = Alignment.CenterVertically,
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
       cards(1,"Sneakers"),
       cards(2,"Watches"),
       cards(3,"Bags"),
   )
    LazyRow(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth()){
        itemsIndexed(mycards){ _,it ->
            Chippart(name = it.name, id = it.id)
        }
    }
}