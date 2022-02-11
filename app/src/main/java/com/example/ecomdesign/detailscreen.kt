package com.example.ecomdesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecomdesign.homeui.iconsize
import com.example.ecomdesign.homeui.paddingval

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