package com.deto.mediaexplorer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


fun getCategories() : List<Category>{
    val categories = listOf(

        Category(1,"Anime","Animaciones Japonesas"),
        Category(1,"Peliculas","Obra audiovisual de un tiempo determinado"),
        Category(1,"Series","Obra audiovisual separado en varios capitulos")

    )
    return categories
}

class Category(val id: Int, val title: String, val description: String)

@Composable
fun HomeScreen( navController: NavController ){
    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

        }

    }
}