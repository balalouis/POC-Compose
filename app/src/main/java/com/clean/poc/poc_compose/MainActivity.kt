package com.clean.poc.poc_compose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val personList: List<Person> = mutableListOf(
            Person("Arun", "Salem"),
            Person("Anand", "Salem"),
            Person("Banana", "France"),
            Person("Chitra", "Chennai")
        )

        setContent {
//            DisplayText(Person("Arun kumar", "Salem"))
            conversation(personList)
        }
    }
}

@Composable
fun conversation(listPerson: List<Person>) {
    LazyColumn {
        items(listPerson) { person ->
            DisplayText(person)
        }
    }
}

data class Person(val name: String, val location: String)

@Composable
fun DisplayText(person: Person) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column {
            Text(
                text = "Hello ${person.name}",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.5.dp) {
                Text(
                    text = person.location,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Button(
            onClick = { "Hello World" },
            interactionSource = interactionSource,
            modifier = Modifier.padding(all = 4.dp)
        ) {
            Text(if (isPressed) "Pressed!" else "Not pressed")
        }
    }
}

@Preview
@Composable
fun DisplayTextPreview() {
    DisplayText(Person("Arun kumar", "Salem"))
}