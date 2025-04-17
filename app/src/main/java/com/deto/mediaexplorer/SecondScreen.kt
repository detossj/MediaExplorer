package com.deto.mediaexplorer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.onPrimaryContainerLight
import com.example.compose.onTertiaryDark
import com.example.compose.onTertiaryLight
import com.example.compose.primaryContainerDark
import com.example.compose.primaryContainerLight
import com.example.compose.secondaryContainerDark
import com.example.compose.secondaryContainerLight
import com.example.compose.surfaceContainerDark
import com.example.compose.surfaceDark
import com.example.compose.tertiaryContainerLight

val categories = getCategories()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen( navController: NavController, category:Int ,list: List<Category>){

    val SelectedCategory = list.find { it.id == category }


    var selected by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(stringResource(R.string.second_title), stringResource(R.string.second_subtitle))},
        containerColor = secondaryContainerDark,
        contentColor = onPrimaryContainerLight,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NewElement(category))},
                containerColor = surfaceContainerDark,
                contentColor = onTertiaryLight

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
                        onClick = {

                        }
                    ) {
                        Text(stringResource(R.string.second_bottom))
                    }

                    Button(
                        onClick = { if( selected == 0 ) {} else navController.navigate(ElementScreen(category,selected)) },
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonColors(
                            containerColor = primaryContainerDark,
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        )
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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(20.dp),
                modifier = Modifier.fillMaxWidth()

            ) {
                items(SelectedCategory?.elements?: emptyList()  ) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { selected = it.id },
                        colors = CardColors(
                            contentColor = Color.White,
                            containerColor =  if (selected == it.id ) onTertiaryDark else primaryContainerDark,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Columna izquierda: imagen
                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                if(it.Imagen == null){
                                    Image(
                                            painter = painterResource(R.drawable.no_photography_24px),
                                        contentDescription = "Image Element",
                                        modifier = Modifier.size(200.dp)
                                    )

                                } else {
                                    Image(
                                        painter = painterResource(it.Imagen!!),
                                        contentDescription = "Image Element",
                                        modifier = Modifier.size(200.dp)
                                    )
                                }

                            }

                            // Columna derecha: título y descripción
                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(start = 16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = it.classification.toString(),
                                        fontSize = 18.sp
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.star_24px),
                                        contentDescription = "classification",
                                        modifier = Modifier
                                            .padding(start = 4.dp)
                                            .size(18.dp)
                                    )
                                }
                                Text(
                                    text = it.title,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = if( it.description.length > 100) it.description.take(100) + "..." else it.description,
                                    fontSize = 14.sp
                                )


                            }
                        }

                    }
                }
            }

        }

    }

}