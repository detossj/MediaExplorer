package com.deto.mediaexplorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


fun getCategories() : List<Category>{
    val categories = listOf(

        Category(1,"Anime","Animaciones Japonesas",R.drawable.manga_24px),
        Category(2,"Peliculas","Obra audiovisual de un tiempo determinado",R.drawable.movie_24px),
        Category(3,"Series","Obra audiovisual separado en varios capitulos",R.drawable.live_tv_24px),
        Category(4,"Novela","Obra audiovisual separado en varios capitulos",R.drawable.menu_book_24px),
        Category(5,"Series","Obra audiovisual separado en varios capitulos",R.drawable.live_tv_24px),
        Category(6,"Novela","Obra audiovisual separado en varios capitulos",R.drawable.menu_book_24px),
        Category(7,"Novela","Obra audiovisual separado en varios capitulos",R.drawable.menu_book_24px),
        Category(8,"Series","Obra audiovisual separado en varios capitulos",R.drawable.live_tv_24px),
        Category(9,"Novela","Obra audiovisual separado en varios capitulos",R.drawable.menu_book_24px)

    )
    return categories
}

class Category(val id: Int, val title: String, val description: String, val icon: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController ){

    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LargeTopAppBar(
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                title = {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {

                        Text(
                            text = stringResource(R.string.title),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )

                        Text(
                            text = stringResource(R.string.subtitle),
                            fontSize = 15.sp
                        )

                    }
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = Color.Cyan,
                contentColor = Color.White

            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding).fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(20.dp),
                modifier = Modifier.fillMaxWidth()

            ) {
                items(getCategories()) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { selected = it.id }

                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 20.dp, vertical = 35.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painterResource(it.icon),
                                contentDescription = "Category Box",
                                modifier = Modifier.size(50.dp)
                            )

                            Text(
                                text = it.title,

                            )
                        }

                    }
                }
            }

        }

    }
}