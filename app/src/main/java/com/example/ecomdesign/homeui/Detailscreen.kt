package com.example.ecomdesign.homeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecomdesign.toppartdeatail
import com.example.ecomdesign.ui.theme.EcomdesignTheme

class Detailscreen : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcomdesignTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(Modifier.fillMaxSize()) {
                        toppartdeatail()
                        greet()
                    }
                }
            }
        }
    }
}

@Composable
fun greet() {
    Text(text = "DetailScreen")
}