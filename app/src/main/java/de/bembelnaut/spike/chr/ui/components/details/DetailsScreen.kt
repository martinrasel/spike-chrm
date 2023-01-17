package de.bembelnaut.spike.chr.ui.components.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.bembelnaut.spike.chr.ui.theme.CHRTheme

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    message: String,
    joke: String,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(message)

            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = joke
            )
        }
    }
}

@Composable
fun Greeting(message: String) {
    Text(text = "$message")
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    CHRTheme {
        DetailsScreen(
            modifier = Modifier,
            message = "Android",
            joke = "Eight bytes walk into a bar.\nThe bartender asks, \"Can I get you anything?\"\n\"Yeah,\" reply the bytes.\n\"Make us a double.\""
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsScreen() {
    CHRTheme {
        Greeting("Android")
    }
}