package com.clean.poc.poc_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clean.poc.poc_compose.ui.theme.POCComposeTheme
import androidx.compose.foundation.lazy.items

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppList()
        }
    }

    @Composable
    private fun MyApp(list: List<String> = listOf("Arun", "Anand", "Chitra")) {
        Surface(color = MaterialTheme.colors.background) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                for (text in list) {
                    DisplayText(text = text)
                }
            }
        }
    }

    @Composable
    private fun MyAppList(names: List<String> = List(1000) { "$it" }) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                DisplayText(name)
            }
        }
    }

    @Composable
    fun DisplayText(text: String) {
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            val expanded = remember { mutableStateOf(false) }
            val extraPadding = if (expanded.value) 48.dp else 0.dp
            Row(modifier = Modifier.padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                )
                {
                    Text(text = "Hello")
                    Text(text = text)
                }
                OutlinedButton(onClick = {
                    expanded.value = !expanded.value
                    Log.i("-----> ", "Button clicked")
                }) {
                    Text(if (expanded.value) "Show more" else "Show less")
                }
            }
        }
    }

    @Preview(showBackground = true, name = "Text preview")
    @Composable
    fun DisplayTextPreview() {
        POCComposeTheme {
            MyApp()
        }
    }

}