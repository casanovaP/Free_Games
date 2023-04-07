package com.example.freegames.di

import com.example.freegames.data.remote.GamesApi
import com.example.freegames.data.repository.GamesRepositoryImpl
import com.example.freegames.domain.repository.GamesRepository
import com.example.freegames.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/* code handly written by Petre A. Moraru, Aka: Trigger **/

@Module
@InstallIn(SingletonComponent::class)
object GamesAppModule {

    @Provides
    @Singleton
    fun provideApi(): GamesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(GamesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: GamesApi): GamesRepository {
        return GamesRepositoryImpl(api)
    }

}