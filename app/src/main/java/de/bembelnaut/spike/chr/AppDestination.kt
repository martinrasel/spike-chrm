package de.bembelnaut.spike.chr

// Navigation: 2.11) Hilfsklasse um alle Routen und Argumente zu verwalten.
interface AppDestination {
    val route: String
}

object Welcome : AppDestination {
    override val route = "welcome"
}

object Detail : AppDestination {
    override val route = "detail"
}