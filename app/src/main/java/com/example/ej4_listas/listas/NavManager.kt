package com.example.ej4_listas.listas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*

@Composable
fun NavManager(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "categorias",
        modifier = modifier
    ) {

        composable("categorias") {
            CategoryView(navController)
        }

        composable("productos/{categoria}") { backStackEntry ->

            val categoria = backStackEntry.arguments
                ?.getString("categoria") ?: ""

            ProductView(categoria)
        }
    }
}