package com.deto.mediaexplorer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class SecondScreen( val category: Int)

@Serializable
object NewCategory

@Serializable
data class NewElement( val categoryId: Int)



@Composable
fun Navigation(){


    var list = remember { getCategories().toMutableStateList() }


    val navController = rememberNavController()

    NavHost( navController = navController, startDestination = Home ){

        composable<Home> {
            HomeScreen(navController = navController,list)
        }

        composable<SecondScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<SecondScreen>()
            SecondScreen(navController = navController, category = args.category,list = list)
        }

        composable<NewCategory> {
            NewCategory(navController = navController, add = { list.add(it) })
        }

        composable<NewElement> { backStackEntry ->
            val args = backStackEntry.toRoute<NewElement>()
            NewElement(navController = navController, category = args.categoryId, addElement = { newElement,categoryId -> list.find { it.id == categoryId }?.elements?.add(newElement) })
        }


    }
}