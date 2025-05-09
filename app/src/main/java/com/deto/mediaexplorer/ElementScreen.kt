package com.deto.mediaexplorer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
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
import com.example.compose.onSecondaryLight
import com.example.compose.primaryContainerDark
import com.example.compose.secondaryContainerDark
import com.example.compose.secondaryContainerLight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElementScreen( navController: NavController, idCategory: Int, idElement: Int, list: List<Category>){


    val SelectedElement = list.find { it.id == idCategory }?.elements?.find { it.id == idElement  }

    val scrollState = rememberScrollState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = secondaryContainerDark,
        contentColor = onPrimaryContainerLight,
        topBar = {
            LargeTopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                colors = TopAppBarColors(
                    containerColor = secondaryContainerDark,
                    titleContentColor = onSecondaryLight,
                    actionIconContentColor = secondaryContainerDark,
                    scrolledContainerColor = secondaryContainerLight,
                    navigationIconContentColor = secondaryContainerLight
                ),
                title = {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = SelectedElement?.title ?: "",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 32.sp,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(1f)
                            )

                            Text(
                                text = SelectedElement?.classification.toString(),
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


                    }
                }

            )
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
                        Text(stringResource(R.string.element_bottom))
                    }

                    Button(
                        onClick = { navController.navigate(Home) },
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
            modifier = Modifier.padding(innerPadding)
        ){

            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 20.dp).verticalScroll(scrollState)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if(SelectedElement?.Imagen == null){
                        Image(
                            painter = painterResource(R.drawable.no_photography_24px),
                            contentDescription = "Image Element",
                            modifier = Modifier
                                .size(300.dp)
                                .align(Alignment.CenterHorizontally)

                        )

                    } else {
                        Image(
                            painter = painterResource(SelectedElement.Imagen!!),
                            contentDescription = "Image Element",
                            modifier = Modifier
                                .size(300.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    Text(
                        text = SelectedElement?.description ?: "",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                    )

                }

            }


        }

    }
}