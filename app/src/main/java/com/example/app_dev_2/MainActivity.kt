@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.app_dev_2

import android.content.res.Configuration
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_dev_2.ui.theme.App_Dev_2Theme
import com.example.app_dev_2.ui.theme.Typography
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_Dev_2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        var listCount by rememberSaveable { mutableStateOf(listOf<Int>()) }
        var maxOwnAnimal = 5
        var maxOwnDonation = 10
        if (count == maxOwnAnimal) {
            Text("You've can't own more than $maxOwnAnimal")
        }

        Text("You've had $count glasses.")

        Text("${listCount.size}")
        Row {
            listCount.forEach() { text ->
                Text(text.toString())
            }
        }


        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < maxOwnAnimal && listCount.size < maxOwnDonation) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)) {
                Text("Clear water count")
            }
            Button(onClick = { listCount += count}, enabled = count < maxOwnAnimal && listCount.size < maxOwnDonation) {
                Text("Donate")
            }
        }
    }
}

@Composable
fun RadioButtonSample() {
    val radioOptions = AnimalData()
    val animals = AnimalData()
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }


        Text(selectedOption.name)


    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text.name == selectedOption.name),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)

            ) {
                RadioButton(
                    selected = (text.name == selectedOption.name),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text.name
                )
            }
        }
    }
}


@Composable
fun buttonTest() {
    val radioOptions = AnimalData()
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    var count by rememberSaveable { mutableStateOf(0) }

    Text( "Select to see these horse favorite fruit")
    Row {
        Column {
            radioOptions.forEach { text ->
                Row(Modifier.padding(top = 10.dp)){
                    Button(onClick = { onOptionSelected(text) }) {
                        Image(
                            painter = text.image,
                            contentDescription = "animal ye",
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(50.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = text.name)
                    }
                }

            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text( "${selectedOption.name} favorite food is:")
            Image(painter = selectedOption.image, contentDescription = "A"
            ,modifier = Modifier
                    .height(150.dp)
                    )
        }




    }
}






@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = { newText ->
            searchText = newText // Update the outer search text variable when the user types
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}


@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var showTitleScreen by rememberSaveable { mutableStateOf(true) }

    if (showTitleScreen)
    {
        TitleScreen(onContinueClicked = { showTitleScreen = false })
    }
    else {
        Scaffold(
            topBar = {
                 TopAppBar(
                     title = { Text(text = "My App",
                     textAlign = TextAlign.Center, color = Color.White,
                     modifier = Modifier.fillMaxWidth())},
                     colors = TopAppBarDefaults.smallTopAppBarColors(MaterialTheme.colorScheme.primary)
                 )
            },
            content = { paddingValues ->
                Surface(
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState())

                    ) {
                        AnimalInfo()
                        WaterCounter()
                        buttonTest()
                    }
                }
            }
        )
    }
}

@Composable
fun TitleScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Animal Zoo Wiko\n", style = Typography.titleLarge)
        Text("Welcome! here you will be able to learn more about our animals and be " +
                "able to do an act of charity to these animals",
            style = Typography.bodyLarge, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Let's go!")
        }
    }
}

@Composable
private fun AnimalInfo(
    modifier: Modifier = Modifier,
) {
    val animals = AnimalData()
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        animals.forEach(){ animal ->
            AnimalInfo(animal = animal)
        }
    }
}

@Composable
private fun AnimalInfo(animal: Animal) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(animal)
    }
}

@Composable
private fun CardContent(animal: Animal) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var checked by remember { mutableStateOf(false) }

    //Make text color with that card white
    CompositionLocalProvider(LocalContentColor provides Color.White) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Row(modifier = Modifier
                .padding(12.dp)){

                Image(painter = animal.image,
                    contentDescription = "animal ye",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop)

                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = animal.name, style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier
                        .alignByBaseline()
                        .offset(y = 25.dp)
                )
            }
            if (expanded) {
                Text(
                    text = animal.description
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    App_Dev_2Theme {
        MyApp()
    }
}