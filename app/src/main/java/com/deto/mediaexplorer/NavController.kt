package com.deto.mediaexplorer

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class SecondScreen( val category: String)

@Serializable
data class NewCategory( val listCategory: String )

@Serializable
data class NewElement( val listElement: String )

@Composable
fun Navigation(){



    val navController = rememberNavController()

    NavHost( navController = navController, startDestination = Home ){

        composable<Home> {
            HomeScreen(navController = navController)
        }

        composable<SecondScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<SecondScreen>()
            SecondScreen(navController = navController, category = args.category)
        }

        composable<NewCategory> { backStackEntry ->
            val args = backStackEntry.toRoute<NewCategory>()
            NewCategory(navController = navController, listCategory = args.listCategory)
        }

        composable<NewElement> { backStackEntry ->
            val args = backStackEntry.toRoute<NewElement>()
            NewElement(navController = navController, listElement = args.listElement)
        }


    }
}