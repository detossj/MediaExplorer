package com.deto.mediaexplorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen( navController: NavController, category:Int ){

    var selected by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LargeTopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                title = {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {

                        Text(
                            text = "Elements",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )

                        Text(
                            text = "Please select a element",
                            fontSize = 15.sp
                        )

                    }
                }
            )

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = Color.LightGray,
                contentColor = Color.White

            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        modifier = Modifier.fillMaxWidth(.7f),
                        onClick = {}
                    ) {
                        Text("View element")
                    }

                    Button(
                        onClick = { if( selected == 0 ) {} else navController.navigate(SecondScreen(selected)) },
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "advance",
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                }
            }
        }


    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

        }

    }

}