package com.example.ecomdesign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.ecomdesign.homeui.*
import com.example.ecomdesign.ui.theme.EcomdesignTheme

class MainActivity : ComponentActivity(), clicker {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcomdesignTheme {
                var index = remember { mutableStateOf(0) }
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            elevation = FloatingActionButtonDefaults.elevation(12.dp)
                        ) {
                            Icon(
                                Icons.Rounded.ShoppingCart,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center,
                    backgroundColor = Color.White,
                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier.padding(1.dp),
                            cutoutShape = CircleShape,
                            contentPadding = PaddingValues(end = 4.dp),
                            backgroundColor = colorResource(id = R.color.mywhite)
                        ) {
                            BottomNavigationItem(
                                selected = (index.value == 0),
                                onClick = { index.value = 0 },
                                icon = {
                                    Icon(
                                        Icons.Default.AccountBox,
                                        contentDescription = null,
                                        tint = Color.Black
                                    )
                                })
                            BottomNavigationItem(
                                selected = (index.value == 1),
                                onClick = { index.value = 1 },
                                icon = {
                                    Icon(
                                        Icons.Default.Call,
                                        contentDescription = null,
                                        tint = Color.Black
                                    )
                                })
                            BottomNavigationItem(
                                selected = (index.value == 3),
                                onClick = { index.value = 3 },
                                icon = {
                                    Icon(
                                        Icons.Default.Star,
                                        contentDescription = null,
                                        tint = Color.Black
                                    )
                                })
                            BottomNavigationItem(
                                selected = (index.value == 4),
                                onClick = { index.value = 4 },
                                icon = {
                                    Icon(
                                        Icons.Default.Search,
                                        contentDescription = null,
                                        tint = Color.Black
                                    )
                                })

                        }
                    },
                ) { innerpadding ->
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(innerpadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        toppart()
                        Spacer(modifier = Modifier.padding(1.dp))
                        titlepart()
                        Spacer(modifier = Modifier.padding(1.dp))
                        Chipgrp()
                        Spacer(modifier = Modifier.padding(1.dp))
                        val listofcards = listOf(
                            items(
                                name = "Adidas SX",
                                price = "$ 350.00"
                            ),
                            items(
                                name = "Nike Sz r",
                                price = "$ 150.00"
                            ),
                            items(
                                name = "Reebok Super ",
                                price = "$ 59.99"
                            ),
                            items(
                                name = "skechers Z",
                                price = "$ 559.99"
                            ),
                            items(
                                name = "skechers Z",
                                price = "$ 559.99"
                            ),
                            items(
                                name = "skechers Z",
                                price = "$ 559.99"
                            ),
                        )
                        LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier
                            .scrollable(
                                orientation = Orientation.Vertical,
                                state = rememberScrollState()
                            )
                            .padding(bottom =10.dp),
                            contentPadding = PaddingValues(
                                start = 5.dp,
                                end = 5.dp,
                                top = 6.dp,
                                bottom = 2.dp
                            ), content = {

                                itemsIndexed(listofcards) { _, cont ->
                                    productcards(
                                        onclick = this@MainActivity,
                                        name = cont.name,
                                        price = cont.price
                                    )
                                }
                            })

                    }
                }
            }
        }
    }

    override fun clickit() {
        Toast.makeText(this, "Functon Inside", Toast.LENGTH_LONG).show()
    }

    override fun nowclick() {
        startActivity(Intent(this,Detailscreen::class.java))
        finish()
    }
}

