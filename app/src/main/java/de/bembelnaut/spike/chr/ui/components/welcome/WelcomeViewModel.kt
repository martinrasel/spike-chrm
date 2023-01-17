package de.bembelnaut.spike.chr.ui.components.welcome

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.bembelnaut.spike.chr.service.datasource.SomeInterface
import javax.inject.Inject

// Hilt: 1.13) ViewModel definieren
// Hilt: 1.13) Achtung! Scopes von Dependencies muss passen
// Navigation: 2.10) Am ViewModel ändert sich nichts, auch wenn es am Graphen haengt
@HiltViewModel
class WelcomeViewModel
@Inject constructor(
    private val someInterface: SomeInterface
) : ViewModel() {

    fun getName(): String {
        return someInterface.getSomeModel().someString
    }
}