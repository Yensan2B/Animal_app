package com.example.app_dev_2

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

data class Animal(val name: String, val image: Painter, val description: String)

@Composable
fun AnimalData(): List<Animal> {
    val animals: List<Animal> = listOf(
        Animal("Alice", painterResource(id = R.drawable.horse), "ye"),
        Animal("Bob", painterResource(id = R.drawable.horse), "yo"),
        Animal("Charlie", painterResource(id = R.drawable.horse), "ya")
    )
    return animals
}