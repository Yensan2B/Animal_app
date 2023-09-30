package com.example.app_dev_2

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

data class Animal(val name: String, val image: Painter, val description: String, val food: Painter)

@Composable
fun AnimalData(): List<Animal> {
    return listOf(
        Animal("Horse", painterResource(id = R.drawable.horse), "ye", painterResource(id = R.drawable.carrots)),
        Animal("Seal", painterResource(id = R.drawable.seal), "yo", painterResource(id = R.drawable.flatfish)),
        Animal("Panda", painterResource(id = R.drawable.panda), "ya", painterResource(id = R.drawable.bamboo)),

    )
}