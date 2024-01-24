package com.openinapp.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.openinapp.data.implementations.NetworkDataSourceImpl
import com.openinapp.data.services.NetworkService
import com.openinapp.domain.interfaces.NetworkDataSource
import com.openinapp.domain.misc.TokenInterceptor
import com.openinapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNetworkService(@ApplicationContext context: Context): NetworkService {
        val httpInterceptor = HttpLoggingInterceptor {}
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val tokenInterceptor = TokenInterceptor(context)

        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(10, TimeUnit.MINUTES) // write timeout
            .readTimeout(10, TimeUnit.MINUTES) // read timeout
            .addInterceptor(tokenInterceptor)
            .addInterceptor(httpInterceptor)
            .build()

        JsonObject()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(NetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesNetworkDataSource(networkService: NetworkService): NetworkDataSource {
        return NetworkDataSourceImpl(networkService)
    }
}