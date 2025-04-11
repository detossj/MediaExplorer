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
import androidx.compose.runtime.mutableStateListOf
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



fun getCategories() : MutableList<Category>{
    var categories = mutableListOf(

        Category(1,"Anime",R.drawable.manga_24px,mutableListOf(
            Element(1,"Naruto","Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale.",R.drawable.naruto),
            Element(2,"Dragon Ball Z","En Dragon Ball Z, Goku, ahora adulto y casado con Milk, descubre que no es humano, sino un saiyajin, una raza de guerreros poderosos. Esto da paso a los verdaderos enemigos de la serie.",R.drawable.dragonballz),
            Element(3,"One Piece","One Piece sigue las aventuras de Monkey D. Luffy, un joven que busca el legendario tesoro \"One Piece\" para convertirse en el Rey de los Piratas. A lo largo de su viaje, Luffy forma una tripulación de amigos y enfrenta poderosos enemigos.",R.drawable.onepiece),
        )),
        Category(2,"Peliculas",R.drawable.movie_24px, mutableListOf(
            Element(1,"Minecraft","Una extraña tierra cuadrada que prospera con la imaginación. Para regresar a casa, tendrán que dominar este mundo (y protegerlo de cosas malignas como los Piglins y los Zombis) mientras emprenden una búsqueda mágica con un inesperado experto creador, Steve (Black).",R.drawable.minecraft),
            Element(2,"Blancanieves","Una adaptación en vivo del clásico cuento de hadas sobre una hermosa joven princesa que, mientras es acosada por una reina celosa, busca refugio en la casa de siete enanos en la campiña alemana.",R.drawable.blancanieves),
            Element(3,"Capitan America: Un nuevo mundo","Tras reunirse con el recientemente electo presidente de los Estados Unidos Thaddeus Ross, Sam se encuentra en medio de un conflicto internacional. Debe descubrir la razón de un nefasto complot mundial antes de que el verdadero artífice detrás del mismo haga que el mundo entero entre en caos.",R.drawable.capitanamerica)
        )),
        Category(3,"Series",R.drawable.live_tv_24px, mutableListOf(
            Element(1,"Daredevil","Daredevil es una serie de Marvel que trata de Matt Murdock, un abogado ciego que lucha contra el crimen como el justiciero enmascarado Daredevil.",R.drawable.daredevil),
            Element(2,"The Punisher","The Punisher es una serie de televisión estadounidense de Marvel que narra la historia de Frank Castle, un ex soldado que se convierte en un justiciero enmascarado. Su objetivo es vengar el asesinato de su familia.",R.drawable.thepunisher),
            Element(3,"Iron Fist","Iron Fist es una serie de televisión de Marvel que narra la historia de Danny Rand, un joven que regresa a Nueva York tras años de desaparición. Danny posee un dominio del kung-fu y la habilidad de invocar el Puño de Hierro",R.drawable.ironfist)

        )),
        Category(4,"Novela",R.drawable.menu_book_24px, mutableListOf(
            Element(1,"Papá a la deriva","Bruno Montt es un reconocido capitán de la Marina que enviudó hace cinco años. Desde entonces, se ha dedicado con dedicación y disciplina a la educación de sus cuatro hijos. Pero esta labor no ha sido fácil. A pesar de sus esfuerzos por ser un excelente padre, sus hijos aún necesitan una madre. Es entonces cuando Violeta, la hija del mayordomo, llega a la residencia Montt, conquistando a la familia.",R.drawable.papaaladeriva),
            Element(2,"Pobre gallo","Nicolás Pérez de Castro es un empresario que sólo piensa en el trabajo y que vive conectado a todos los aparatos tecnológicos existentes, dejando de lado a su familia, a los que no les presta nada de atención. Por esto, su esposa Florencia, cansada de que no la tomen en cuenta, lo abandona.",R.drawable.pobregallo),
            Element(3,"Pituca sin lucas","Narra la caída de una mujer acostumbrada a los lujos y la buena vida, quien tras una mala maniobra financiera de su marido queda en la ruina y debe partir de cero.",R.drawable.pitucasinlucas)
        )),
        Category(5,"Series",null),
        Category(6,"Novela",null),
        Category(7,"Novela",null),
        Category(8,"Series",null),
        Category(9,"Novela",null)

    )
    return categories
}


class Element(
    var id: Int,
    var title: String,
    var description: String,
    var Imagen: Int?
)

class Category(
    var id: Int,
    var title: String,
    var icon: Int?,
    var elements: List<Element> = emptyList()
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController, listCategory: List<Category> ){


    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(stringResource(R.string.home_title),stringResource(R.string.home_subtitle))},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  navController.navigate(NewCategory)},
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
                        onClick = { if( selected == 0 ) {} else   navController.navigate(SecondScreen(selected)) },
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
                items(listCategory) {
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


                            if(it.icon == null) {

                                Icon(
                                    painterResource(R.drawable.noimage),
                                    contentDescription = "Category Box",
                                    modifier = Modifier.size(60.dp)
                                )

                            } else {
                                Icon(
                                    painterResource(it.icon!!),
                                    contentDescription = "Category Box",
                                    modifier = Modifier.size(60.dp)
                                )
                            }



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

