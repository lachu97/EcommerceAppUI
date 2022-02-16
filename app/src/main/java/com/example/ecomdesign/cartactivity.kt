package com.example.ecomdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.ecomdesign.homeui.items
import com.example.ecomdesign.ui.theme.EcomdesignTheme

class Cartactivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcomdesignTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = colorResource(id = R.color.colorcard)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                    ) {
                        carttop()
                        Spacer(modifier = Modifier.padding(10.dp))
                        val mylist = listOf<items>(
                            items("NIke Fx Flex","$ 250.99"),
                            items("Adidas G-F","$ 50.99"),
                            items("Reebok 1G ","$ 150.99"),
                            items("x Force","$ 10.99"),
                            items("ManForce","$ 1.99"),
                        )
                        Surface(color = colorResource(id = R.color.mygray)) {
                            LazyColumn(){
                                itemsIndexed(mylist){ _,shoes ->
                                    cartcard(name = shoes.name, price = shoes.price)
                                }
                            } 
                        }
                      
                    }
                }
            }
        }
    }
}