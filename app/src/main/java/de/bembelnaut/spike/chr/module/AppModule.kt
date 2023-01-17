package de.bembelnaut.spike.chr.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.bembelnaut.spike.chr.domain.SomeModel
import de.bembelnaut.spike.chr.service.datasource.joke.JokeService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

// Hilt: 1.9) Module für Provides
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSomeModel() = SomeModel("Hello World!")

    // Retrofit+Moshi: 3.2) Moshi-Adapter konfigurieren
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Retrofit+Moshi: 3.2) Client konfigurieren
    @Provides
    @Singleton
    fun provideRetrofitClient(
        moshi: Moshi
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev/joke/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    // Retrofit+Moshi: 3.2) Service generieren
    @Provides
    @Singleton
    fun provideJokeService(
        retrofit: Retrofit
    ): JokeService = retrofit.create(JokeService::class.java)

}