package de.bembelnaut.spike.chr.ui.components.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.bembelnaut.spike.chr.ui.theme.CHRTheme

// Navigation: 2.12) Hier werden die Composables erstellt
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    message: String,
    onClickForward: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(message)

            Button(
                onClick = onClickForward,
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Text(
                    text = "What's next?!"
                )
            }
        }
    }
}

@Composable
fun Greeting(message: String) {
    Text(text = "$message!")
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    CHRTheme {
        WelcomeScreen(
            modifier = Modifier,
            message = "Android",
            onClickForward = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CHRTheme {
        Greeting("Android")
    }
}