package com.example.ej4_listas.listas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ej4_listas.R

@Composable
fun ProductView(categoria: String) {

    val productos = when (categoria) {

        "Electrónica" -> listOf(
            Producto("iPhone", "$20,000", R.drawable.phone, true, true),
            Producto("Laptop", "$15,000", R.drawable.laptop, false, false),
            Producto("Audífonos", "$800", R.drawable.headphones, true, false),
            Producto("Tablet", "$5,000", R.drawable.tablet, true, false),
            Producto("Smartwatch", "$3,000", R.drawable.watch, false, true),
            Producto("Cámara", "$10,000", R.drawable.phone, true, false)
        )

        "Ropa" -> listOf(
            Producto("Playera", "$300", R.drawable.ropa, true, false),
            Producto("Jeans", "$800", R.drawable.ropa, false, true),
            Producto("Sudadera", "$600", R.drawable.ropa, true, false),
            Producto("Vestido", "$700", R.drawable.ropa, false, false),
            Producto("Tenis", "$1200", R.drawable.ropa, true, true),
            Producto("Gorra", "$200", R.drawable.ropa, true, false)
        )

        "Hogar" -> listOf(
            Producto("Sofá", "$5000", R.drawable.hogar, false, true),
            Producto("Mesa", "$2000", R.drawable.hogar, true, false),
            Producto("Lámpara", "$500", R.drawable.hogar, true, false),
            Producto("Cama", "$7000", R.drawable.hogar, false, true),
            Producto("Silla", "$800", R.drawable.hogar, true, false),
            Producto("Espejo", "$600", R.drawable.hogar, true, false)
        )

        "Deportes" -> listOf(
            Producto("Balón", "$300", R.drawable.deportes, true, false),
            Producto("Pesas", "$1000", R.drawable.deportes, false, true),
            Producto("Bicicleta", "$6000", R.drawable.deportes, false, true),
            Producto("Guantes", "$200", R.drawable.deportes, true, false),
            Producto("Tenis deportivos", "$1500", R.drawable.deportes, true, false),
            Producto("Casco", "$900", R.drawable.deportes, true, false)
        )

        else -> listOf(
            Producto("Perfume", "$900", R.drawable.belleza, true, true),
            Producto("Maquillaje", "$600", R.drawable.belleza, false, false),
            Producto("Crema", "$300", R.drawable.belleza, true, false),
            Producto("Shampoo", "$150", R.drawable.belleza, true, false),
            Producto("Labial", "$250", R.drawable.belleza, false, true),
            Producto("Bloqueador", "$200", R.drawable.belleza, true, false)
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Categoría: $categoria",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )

        // Fila 3x3 para ver el carrusel 3x3
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(8.dp)
        ) {

            items(productos) { producto ->

                Card(
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(producto.imagen),
                            contentDescription = "",
                            modifier = Modifier.size(70.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            producto.nombre,
                            fontWeight = FontWeight.Bold
                        )

                        Text(producto.precio)

                        if (producto.envioGratis) {
                            Text("Envío gratis")
                        }

                        if (producto.descuento) {
                            Text("Promoción")
                        }
                    }
                }
            }
        }
    }
}