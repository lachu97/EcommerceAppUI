package com.example.ecomdesign.homeui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecomdesign.Cartactivity
import com.example.ecomdesign.bottompartdetail
import com.example.ecomdesign.middleart
import com.example.ecomdesign.toppartdeatail
import com.example.ecomdesign.ui.theme.EcomdesignTheme

class Detailscreen : ComponentActivity(),clicker {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcomdesignTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(Modifier.fillMaxSize()) {
                        toppartdeatail()
                        Spacer(modifier = Modifier.padding(20.dp))
                        middleart()
                        Spacer(modifier = Modifier.padding(10.dp))
                        bottompartdetail(onclick = this@Detailscreen)

                    }
                }
            }
        }
    }

    override fun clickit() {
        startActivity(Intent(this@Detailscreen,Cartactivity::class.java))
    }

    override fun nowclick() {
        TODO("Not yet implemented")
    }
}

@Composable
fun greet() {
    Text(text = "DetailScreen")
}