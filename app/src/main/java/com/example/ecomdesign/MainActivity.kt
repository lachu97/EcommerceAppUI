package com.example.ecomdesign

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.IconCompat
import com.example.ecomdesign.homeui.*
import com.example.ecomdesign.ui.theme.EcomdesignTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity(), clicker {
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
                            modifier = Modifier.padding(4.dp),
                        ) {
                            Icon(
                                Icons.Rounded.ShoppingCart,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center,
                    backgroundColor = Color.White
                    ,bottomBar = {
                        BottomAppBar(
                            modifier = Modifier.padding(1.dp),
                            cutoutShape = MaterialTheme.shapes.small.copy(
                                CornerSize(percent = 50)
                            ),
                            contentPadding = PaddingValues(end = 4.dp)
                        ) {
                            BottomNavigationItem(
                                selected = (index.value == 0),
                                onClick = { index.value = 0 },
                                icon = {
                                    Icon(Icons.Default.AccountBox, contentDescription = null)
                                })
                            BottomNavigationItem(
                                selected = (index.value == 1),
                                onClick = { index.value = 1 },
                                icon = {
                                    Icon(Icons.Default.Call, contentDescription = null)
                                })
                            BottomNavigationItem(
                                selected = (index.value == 3),
                                onClick = { index.value = 3},
                                icon = {
                                    Icon(Icons.Default.Star, contentDescription = null)
                                })
                            BottomNavigationItem(
                                selected = (index.value == 4),
                                onClick = { index.value = 4},
                                icon = {
                                    Icon(Icons.Default.Search, contentDescription = null)
                                })

                        }
                    },
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        toppart()
                        Spacer(modifier = Modifier.padding(10.dp))
                        titlepart()
                        Spacer(modifier = Modifier.padding(10.dp))
                        Chipgrp()
                        Spacer(modifier = Modifier.padding(10.dp))
                        productcards(this@MainActivity, "Nike 200", "$ 250.00")
                    }
                }
            }
        }
    }

    override fun clickit() {
        Toast.makeText(this, "Functon Inside", Toast.LENGTH_LONG).show()
    }

    override fun nowclick() {
        Toast.makeText(this, "Functon CLicked", Toast.LENGTH_LONG).show()
    }
}

