package com.example.app_dev_2

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

data class Animal(val name: String, val image: Painter, val description: String, val food: Painter)

@Composable
fun AnimalData(): List<Animal> {
    return listOf(
        Animal("Horse", painterResource(id = R.drawable.horse),
            "Horses have oval-shaped hooves, long tails," +
                    " short hair, long slender legs, muscular and deep torso build," +
                    " long thick necks, and large elongated heads. " +
                    "The mane is a region of coarse hairs, which extends along" +
                    " the dorsal side of the neck in both domestic and wild species\n\n" +
                    "- Kids Inquiry of Diverse Species",
            painterResource(id = R.drawable.carrots)),


        Animal("Seal", painterResource(id = R.drawable.seal),
            "Seals are semi-aquatic mammals that are in a group called pinnipeds, which means fin-footed." +
                    " There are 32 species of web-footed aquatic mammals that live chiefly in cold seas and whose body " +
                    "shape is round at the middle and tapered at the ends. It is adapted for swift and graceful swimming\n\n" +
                    "-Vedantu",
            painterResource(id = R.drawable.flatfish)),


        Animal("Panda", painterResource(id = R.drawable.panda),
            "The giant panda, a black-and-white bear, has a body typical of bears." +
                    " It has black fur on its ears, eye patches, muzzle, legs, and shoulders." +
                    " The rest of the animal's coat is white.\n\n" +
                    "-Smithsonian's National Zoo",
            painterResource(id = R.drawable.bamboo)),

    )
}