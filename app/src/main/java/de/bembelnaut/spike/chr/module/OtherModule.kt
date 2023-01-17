package de.bembelnaut.spike.chr.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import de.bembelnaut.spike.chr.service.datasource.SomeInterface
import de.bembelnaut.spike.chr.service.datasource.some.SomeInterfaceImpl

// Hilt: 1.10) Module für Binds
@Module
@InstallIn(ViewModelComponent::class)
abstract class OtherModule {

    // Hilt: 1.12) Achtung!
    // Hilt: 1.12) Scopes muessen passen -> SomeInterfaceImpl (und alles was es benoetigt)  muss >= ViewModelScope sein
    @Binds
    abstract fun bindSomeInterface(someInterfaceImpl: SomeInterfaceImpl): SomeInterface
}