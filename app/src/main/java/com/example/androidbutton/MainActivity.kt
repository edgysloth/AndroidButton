package com.example.androidbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbutton.ui.theme.AndroidButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            var value by remember {
                mutableFloatStateOf(0f)
            }
            var checked by remember { mutableStateOf(true) }
            AndroidButtonTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Switch(
                        checked = checked,
                        onCheckedChange =  {
                            checked = it

                        }
                    )
                    Button(onClick = { println("Button:- I am clicked") }) {
                        Icon(
                            Icons.Rounded.ShoppingCart,
                            contentDescription=" "
                        )
                        Text("Add to cart")
                    }
                    FilledTonalButton(
                        onClick = { println("Button:- please Buy now") },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Black)
                    ) {
                        Text("Buy Now", color = Color.White)
                        Icon(
                            Icons.Rounded.Done,
                            contentDescription = " "
                        )
                    }
                    OutlinedButton(
                        onClick = { println("Button:-Give me a tip") },
                        shape = RoundedCornerShape(10.dp)

                    ) {
                        Icon(
                            Icons.Rounded.ThumbUp,
                            contentDescription = " "
                        )

                        Text("Give me a tip")
                    }
                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text("Kindly rate the App")


                    }
                    FloatingActionButton(onClick = { /*TODO*/ },
                        containerColor=Color.Green) {
                        Icon(Icons.Default.Add, contentDescription = "")

                    }
                    Card(colors=CardDefaults.cardColors(containerColor = colorResource(id = R.color.Orange)),
                        modifier=Modifier.size(width = 300.dp, height = 200.dp)
                        ){
                        Text("Introduction")
                        HorizontalDivider(thickness = 2.dp)
                        Text("Signature Look of superiority")
                    }
                    AssistChip(
                        onClick = { Log.d("Assist chip", "hello world") },
                        label = { Text("Assist chip") },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = "Localized description",
                                Modifier.size(AssistChipDefaults.IconSize)
                            )
                        }
                    )
                    Slider(value = value, onValueChange = {
                        value= it
                    } )/*{
                        Text(text=value.toString())
                    }*/


                }
            }
        }
    }
}