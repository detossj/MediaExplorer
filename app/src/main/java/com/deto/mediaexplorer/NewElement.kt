package com.deto.mediaexplorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NewElement(navController: NavController){

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Scaffold(

        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(stringResource(R.string.newelement_title), stringResource(R.string.newelement_subtitle))},
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
                        Text("Add element")
                    }

                    Button(
                        onClick = {  },
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
            modifier = Modifier.padding(innerPadding),

        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 40.dp)
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = title,
                    isError = error,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    placeholder = { Text("Title") }

                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = description,
                    isError = error,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    placeholder = { Text("Description") }

                )



            }
        }

    }

}