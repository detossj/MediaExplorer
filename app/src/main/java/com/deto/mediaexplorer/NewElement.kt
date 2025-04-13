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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.onPrimaryContainerLight
import com.example.compose.secondaryContainerDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewElement(navController: NavController,category: Int, addElement: (Element,Int) -> Unit){

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val classification = listOf<Int>(1,2,3,4,5)
    var selectedClassification by remember { mutableStateOf(classification[0]) }
    var error by remember { mutableStateOf(false) }
    var error2 by remember { mutableStateOf(false) }

    Scaffold(

        modifier = Modifier.fillMaxSize(),
        containerColor = secondaryContainerDark,
        contentColor = onPrimaryContainerLight,
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
                        onClick = {
                            error = title.isEmpty()
                            error2 = description.isEmpty()

                            if( !error && !error2){
                                val selectedCategory = getCategories().find { it.id == category }

                                val newElement = Element((selectedCategory?.elements?.size?:0) + 1 ,title,description,selectedClassification,null)
                                addElement(newElement,category)
                                navController.navigate(SecondScreen(category))
                            }

                        },
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
                    .padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = title,
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.title_24px),
                            contentDescription = "title",
                            tint = Color.White
                        )
                    },
                    supportingText = { if(error) Text("Enter the title") else {} },
                    isError = error,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    placeholder = { Text("Title") }

                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = description,
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.description_24px),
                            contentDescription = "title",
                            tint = Color.White
                        )
                    },
                    supportingText = { if(error2) Text("Enter the description") else {} },
                    isError = error2,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    placeholder = { Text("Description") }

                )

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = selectedClassification.toString(),
                        leadingIcon = {
                            Icon(
                                painterResource(R.drawable.star_24px),
                                contentDescription = "title",
                                tint = Color.White
                            )
                        },
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Classification") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded)},
                        modifier = Modifier
                            .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true)
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),


                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        classification.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(item.toString()) },
                                onClick = {
                                    selectedClassification = item
                                    expanded = false
                                }
                            )
                        }
                    }


                }



            }
        }

    }

}