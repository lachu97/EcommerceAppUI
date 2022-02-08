package com.example.ecomdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecomdesign.homeui.Chipgrp
import com.example.ecomdesign.homeui.productcards
import com.example.ecomdesign.homeui.titlepart
import com.example.ecomdesign.homeui.toppart
import com.example.ecomdesign.ui.theme.EcomdesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcomdesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
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
                        productcards({
                             Unit
                        })
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EcomdesignTheme {
        Greeting("Android")
    }
}