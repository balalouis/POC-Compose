package com.clean.poc.poc_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clean.poc.poc_compose.ui.theme.POCComposeTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayText(Person("Arun kumar", "Salem"))
        }
    }
}

data class Person(val name: String, val location: String)

@Composable
fun DisplayText(person: Person) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column {
            Text(text = "Hello ${person.name}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = person.location)
        }
    }
}

@Preview
@Composable
fun DisplayTextPreview() {
    DisplayText(Person("Arun kumar", "Salem"))
}