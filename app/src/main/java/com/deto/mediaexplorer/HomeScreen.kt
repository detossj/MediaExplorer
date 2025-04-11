package com.deto.mediaexplorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.serialization.Serializable


fun getCategories() : List<Category>{
    var categories = mutableListOf(

        Category(1,"Anime","Animaciones Japonesas",R.drawable.manga_24px,mutableListOf(
            Element(1,"Naruto","Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale.",R.drawable.naruto),
            Element(2,"Dragon Ball Z","En Dragon Ball Z, Goku, ahora adulto y casado con Milk, descubre que no es humano, sino un saiyajin, una raza de guerreros poderosos. Esto da paso a los verdaderos enemigos de la serie.",R.drawable.dragonballz),
            Element(3,"One Piece","One Piece sigue las aventuras de Monkey D. Luffy, un joven que busca el legendario tesoro \"One Piece\" para convertirse en el Rey de los Piratas. A lo largo de su viaje, Luffy forma una tripulación de amigos y enfrenta poderosos enemigos.",R.drawable.onepiece),
        )),
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

class Element(
    var id: Int,
    var title: String,
    var description: String,
    var Imagen: Int
)

class Category(
    var id: Int,
    var title: String,
    var description: String,
    var icon: Int,
    var elements: List<Element> = emptyList()
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController ){

    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(stringResource(R.string.home_title),stringResource(R.string.home_subtitle))},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NewCategory)},
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
                        Text("View elements of the category")
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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight()
                .fillMaxWidth(),
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
                            .clickable { selected = it.id },
                        colors = CardColors(
                            contentColor = Color.White,
                            containerColor =  if (selected == it.id ) Color.Red else Color.Gray ,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        )

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
                                modifier = Modifier.size(60.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar( title: String, subtitle: String){

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
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Text(
                    text = subtitle,
                    fontSize = 15.sp
                )

            }
        }

    )

}

