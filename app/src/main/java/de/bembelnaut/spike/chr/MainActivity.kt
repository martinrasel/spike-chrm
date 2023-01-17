package de.bembelnaut.spike.chr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import de.bembelnaut.spike.chr.ui.theme.CHRTheme
import de.bembelnaut.spike.chr.ui.components.welcome.WelcomeViewModel

// Hilt: 1.8) Entry point
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Navigation: 2.8) ViewModel haegen am Navigations Graphen
    // private val welcomeViewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CHRTheme {
                // Navigation: 2.2) NavController ist die API fuer das Navigieren und haelt den Back-Stack,...
                val navController = rememberNavController()

                // Navigation: 2.3) NavigationHost enthaelt alle Routen
                NavigationHost(
                    modifier = Modifier.fillMaxSize(),
                    navHostController = navController,
                )

            }
        }
    }
}
