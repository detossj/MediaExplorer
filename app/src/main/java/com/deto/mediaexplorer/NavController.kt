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
data class SecondScreen( val category: Int)

@Serializable
object NewCategory

@Serializable
object NewElement

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
            NewCategory(navController = navController)
        }

        composable<NewElement> { backStackEntry ->
            val args = backStackEntry.toRoute<NewElement>()
            NewElement(navController = navController)
        }


    }
}