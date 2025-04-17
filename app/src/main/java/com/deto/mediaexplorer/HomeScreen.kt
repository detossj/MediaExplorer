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
import androidx.compose.material3.ButtonColors
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
import androidx.compose.material3.TopAppBarColors
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
import com.example.compose.onPrimaryContainerLight
import com.example.compose.onSecondaryLight
import com.example.compose.onTertiaryDark
import com.example.compose.onTertiaryLight
import com.example.compose.primaryContainerDark
import com.example.compose.primaryContainerLight
import com.example.compose.primaryLight
import com.example.compose.secondaryContainerDark
import com.example.compose.secondaryContainerLight
import com.example.compose.surfaceContainerDark
import com.example.compose.tertiaryContainerLight
import kotlinx.serialization.Serializable



fun getCategories() : MutableList<Category>{
    var categories = mutableListOf(

        Category(1,"Anime",R.drawable.manga_24px,mutableListOf(
            Element(1,"Naruto","Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale. Lo que descubre al inicio de la historia es que la gente le mira con desconfianza porque en su interior está encerrado el demonio Kyubi que una vez destruyó la aldea, y que el anterior líder de la misma tuvo que encerrar en su cuerpo siendo aún muy pequeño, a coste de su vida. Aunque sus compañeros no saben esto, tampoco le aprecian porque es mal estudiante y siempre está haciendo bromas. Sin embargo, la forma de actuar y la determinación de Naruto demuestran a los demás que puede llegar muy lejos, y el recelo de los otros chicos se va disipando. Naruto y sus compañeros Sakura y Sasuke, junto a su maestro Kakashi tendrán que enfrentarse a una serie de combates y misiones a lo largo de la historia que les permitirán mejorar y crecer. Naruto se vera enfrentado a sus principales enemigos Akatsuki, Itachi y Kisame.",4,R.drawable.naruto),
            Element(2,"Dragon Ball Z","En Dragon ball Z Goku se ha convertido en un adulto y está casado con Milk, con la que tiene un hijo llamado Gohan. En esta segunda saga de Dragon ball Goku descubrirá que no es un terricola, sino que pertenece a una raza de guerreros conocida por ser una de las más poderosas de la galaxia, para posteriormente dar paso a los verdaderos enemigos de la serie. Para poder vencer a los nuevos enemigos que irán surgiendo, Goku y sus amigos tendrán que viajar por otros planetas e incluso al cielo y al infierno. Cada enemigo será más fuerte que el anterior, por lo que tendrán que entrenar muy duro para poder derrotarlos además de que se les irán uniendo nuevos personajes que les ayudarán a vencerlos.",4,R.drawable.dragonballz),
            Element(3,"One Piece","Una historia épica de piratas, donde narra la historia de \"Monkey D. Luffy\" quien cuando tenia 7 años, comió accidentalmente una \"Akuma no mi\"(Fruta del diablo) la cual le convirtió en un hombre de goma. Por otra parte \"Gol D. Roger\" conocido como \"El rey de los Piratas\" quien fuera ejecutado por la Marine, habló antes de morir, acerca de su mayor tesoro,el \"One Piece\" escondido en la \"Gran line\". Esta noticia desató la gran era de los piratas lanzando a incontables piratas a ese lugar, en busca del \"One Piece\" el tesoro perdido. Diez años después, Luffy inspirado en \"Gol D. Roger\" y un pirata de nombre Akagami no Shanks (Shanks el pelirrojo) se convierte en pirata deseando ser el próximo \"Rey de los Piratas\" y zarpar para conocer amigos y tener aventuras con ellos, teniendo como meta encontrar el \"One Piece\".",5,R.drawable.onepiece),
        )),
        Category(2,"Peliculas",R.drawable.movie_24px, mutableListOf(
            Element(1,"Minecraft","¡Bienvenidos al mundo de Minecraft, donde la creatividad no solo te ayuda a crear, es esencial para la supervivencia! Cuatro inadaptados—Garrett “El Hombre de la Basura” Garrison (Momoa), Henry (Hansen), Natalie (Myers) y Dawn (Brooks)—se encuentran luchando con problemas ordinarios cuando de repente son arrastrados a través de un misterioso portal al Overworld: una extraña tierra cuadrada que prospera con la imaginación. Para regresar a casa, tendrán que dominar este mundo (y protegerlo de cosas malignas como los Piglins y los Zombis) mientras emprenden una búsqueda mágica con un inesperado experto creador, Steve (Black). Juntos, su aventura desafiará a los cinco a ser audaces y reconectarse con las cualidades que hacen a cada uno de ellos creativamente únicos... las mismas habilidades que necesitan para prosperar de nuevo en el mundo real.",4,R.drawable.minecraft),
            Element(2,"Blancanieves","En esta adaptación, Blancanieves es una princesa que, tras la muerte de su madre y el ascenso al trono de su vanidosa madrastra, debe huir al bosque para escapar de los celos de la Reina. Allí encuentra refugio con siete criaturas mágicas y, con la ayuda de Jonathan (interpretado por Andrew Burnap), un joven aldeano que defiende la justicia, se enfrenta a la tiranía de la Reina para devolver la alegría a su reino. .",2,R.drawable.blancanieves),
            Element(3,"Capitan America: Un nuevo mundo","Después de reunirse con el recién electo presidente de los Estados Unidos, Thaddeus Ross (interpretado por Harrison Ford), Sam Wilson se ve envuelto en un incidente internacional. Debe descubrir la razón de un nefasto complot mundial antes de que el verdadero artífice detrás del mismo haga que el mundo entero entre en caos. ",4,R.drawable.capitanamerica)
        )),
        Category(3,"Series",R.drawable.live_tv_24px, mutableListOf(
            Element(1,"Daredevil","Matt Murdock perdió la vista en un accidente durante su infancia, pero el incidente agudizó sus otros sentidos a niveles sobrehumanos. De día, ejerce como abogado comprometido con la justicia; de noche, se convierte en Daredevil, enfrentándose a la corrupción y el crimen organizado que amenazan su barrio. A lo largo de la serie, Matt se enfrenta a enemigos como Wilson Fisk (Kingpin), un poderoso criminal que busca controlar la ciudad desde las sombras. La narrativa explora los dilemas morales de Murdock, su fe católica y las consecuencias de su doble vida. ",5,R.drawable.daredevil),
            Element(2,"The Punisher","Después de vengar la muerte de su esposa e hijos, Frank Castle descubre una conspiración que va más allá del crimen organizado de Nueva York. Ahora conocido como \"The Punisher\", debe desentrañar la verdad sobre las injusticias que afectan no solo a su familia, sino a toda la sociedad. ",5,R.drawable.thepunisher),
            Element(3,"Iron Fist","Iron Fist es una serie de televisión de Marvel que se estrenó en 2017 en Netflix, protagonizada por Finn Jones como Danny Rand, un experto en artes marciales con la capacidad de invocar el poder místico del \"Puño de Hierro\". La serie sigue a Rand mientras regresa a Nueva York después de haber sido dado por muerto durante 15 años, intentando reconectar con su pasado y el legado de su familia, enfrentándose a elementos criminales que corrompen la ciudad. ",4,R.drawable.ironfist)

        )),
        Category(4,"Novela",R.drawable.menu_book_24px, mutableListOf(
            Element(1,"Papá a la deriva","La historia sigue al Capitán Bruno Montt (interpretado por Gonzalo Valenzuela), un estricto oficial de la Armada de Chile y viudo desde hace cinco años, que intenta criar a sus cuatro hijos con disciplina militar en Valparaíso. Sin embargo, sus hijos —Cristóbal, Esmeralda, Arturo y Marina— constantemente se meten en problemas, desafiando la rígida estructura que Bruno intenta imponer en el hogar.",2,R.drawable.papaaladeriva),
            Element(2,"Pobre gallo","Nicolás Pérez de Castro (Álvaro Rudolphy) es un exitoso empresario santiaguino, adicto al trabajo y a las redes sociales, que ha descuidado su vida familiar. Su mundo se desmorona cuando su esposa, Florencia (Antonia Zegers), lo abandona por otro hombre. Tras un colapso nervioso, es diagnosticado con vértigo agudo debido al estrés y se ve obligado a desconectarse de su agitada vida. Decide entonces trasladarse con sus hijos, Camila (Montserrat Ballarín) y Borja (Augusto Schuster), al fundo familiar en Yerbas Buenas, su pueblo natal, donde reside su padre Onofre (Jaime Vadell).",5,R.drawable.pobregallo),
            Element(3,"Pituca sin lucas","La historia gira en torno a María Teresa \"Techi\" de la Puente (Emilia Drago), una mujer de la alta sociedad limeña que lleva una vida lujosa y sin preocupaciones. Su mundo se desmorona cuando su esposo enfrenta problemas financieros y huye del país, dejándola sin recursos económicos. Obligada a reinventarse, Techi se muda con sus tres hijas a un barrio de clase media, donde debe adaptarse a una nueva realidad alejada de los lujos a los que estaba acostumbrada.",4,R.drawable.pitucasinlucas)
        )),
        Category(5,"Other",null),
        Category(6,"Other",null),
        Category(7,"Other",null),
        Category(8,"Other",null),
        Category(9,"Other",null)

    )
    return categories
}


class Element(
    var id: Int,
    var title: String,
    var description: String,
    var classification: Int,
    var Imagen: Int?
)

class Category(
    var id: Int,
    var title: String,
    var icon: Int?,
    var elements: MutableList<Element> = mutableListOf()
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController, listCategory: List<Category> ){


    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = secondaryContainerDark,
        contentColor = onPrimaryContainerLight,
        topBar = { TopAppBar(stringResource(R.string.home_title),stringResource(R.string.home_subtitle))},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  navController.navigate(NewCategory)},
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
                        onClick = {}
                    ) {
                        Text(stringResource(R.string.home_bottom))
                    }

                    Button(
                        onClick = { if( selected == 0 ) {} else   navController.navigate(SecondScreen(selected)) },
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
                            containerColor =  if (selected == it.id ) onTertiaryDark else primaryContainerDark,
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

