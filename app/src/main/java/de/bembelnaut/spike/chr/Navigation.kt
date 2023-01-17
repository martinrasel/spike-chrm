package de.bembelnaut.spike.chr

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.bembelnaut.spike.chr.ui.components.details.DetailsScreen
import de.bembelnaut.spike.chr.ui.components.details.DetailsViewModel
import de.bembelnaut.spike.chr.ui.components.welcome.WelcomeScreen
import de.bembelnaut.spike.chr.ui.components.welcome.WelcomeViewModel

// Navigation: 2.5) Hier alle Routen und deren Composables auflisten
@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Welcome.route,
        modifier = modifier,
    ) {
        // Navigation: 2.6) Routen koennen auch Argumente haben
        composable(
            route = Welcome.route
        ) {
            // Navigation: 2.7) Das ViewModel kann an den Graphen gebunden werden
            val backStackEntry = remember { navHostController.getBackStackEntry(Welcome.route) }
            val viewModel: WelcomeViewModel = hiltViewModel(backStackEntry)

            WelcomeScreen(
                modifier = modifier,
                message = viewModel.getName(),
                onClickForward = {
                    navHostController.navigate(Detail.route)
                }
            )
        }

        composable(
            route = Detail.route
        ) {
            val backStackEntry = remember { navHostController.getBackStackEntry(Detail.route) }
            val viewModel: DetailsViewModel = hiltViewModel(backStackEntry)

            // Retrofit+Moshi: 3.6) Joke aus dem ViewModel laden
            DetailsScreen(
                modifier = modifier,
                message = viewModel.getDateTime(),
                joke = viewModel.joke.value.joke
            )
        }
    }
}
