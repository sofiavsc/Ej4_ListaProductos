package com.example.ej4_listas.listas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.ej4_listas.R

@Composable
fun CategoryView(navController: NavHostController) {

    val categorias = listOf(
        Categoria("Electrónica", R.drawable.electronica),
        Categoria("Ropa", R.drawable.ropa),
        Categoria("Hogar", R.drawable.hogar),
        Categoria("Deportes", R.drawable.deportes),
        Categoria("Belleza", R.drawable.belleza)
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            "Categorías",
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            items(categorias) { categoria ->

                Card (
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("productos/${categoria.nombre}")
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(categoria.imagen),
                            contentDescription = "",
                            modifier = Modifier.size(70.dp)
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(categoria.nombre)
                    }
                }
            }
        }
    }
}