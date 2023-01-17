package de.bembelnaut.spike.chr.ui.components.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.bembelnaut.spike.chr.domain.Joke
import de.bembelnaut.spike.chr.service.datasource.joke.JokeService
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject constructor(
    private val jokeService: JokeService
) : ViewModel() {
    // Retrofit+Moshi: 3.5) Compose achtet auf den State des Feldes und rendert die entsprechenden Components neu
    private val _joke = mutableStateOf(Joke(id = "-1", joke = ""))
    val joke: State<Joke>
        get() = _joke

    init {
        updateJoke()
    }

    fun getDateTime(): String {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy || HH:mm"))
    }

    // Retrofit+Moshi: 3.4) Service muss über eine Coroutine aufgerufen werden
    // Retrofit+Moshi: 3.7) Achtung! java.net.SocketException: socket failed: EPERM (Operation not permitted) -> App deinstallieren und neu aufspielen
    fun updateJoke() {
        viewModelScope.launch {
            _joke.value = jokeService.getAnyJoke("single")
        }
    }
}