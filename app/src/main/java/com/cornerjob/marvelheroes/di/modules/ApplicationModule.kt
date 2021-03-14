package com.cornerjob.marvelheroes.di.modules

import com.cornerjob.marvelheroes.BuildConfig
import com.cornerjob.marvelheroes.data.net.MarvelHeroesHelper
import com.cornerjob.marvelheroes.data.net.MarvelHeroesImpl
import com.cornerjob.marvelheroes.data.net.MarvelHeroesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.InstallIn
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn((ApplicationComponent::class))
class ApplicationModule {
    @Provides
    fun provideBaseUrl() = BuildConfig.API_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
                .addInterceptor(MarvelApiInterceptor())
                .build()
    } else OkHttpClient
            .Builder()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
            okHttpClient: OkHttpClient,
            BASE_URL: String
    ): Retrofit =
            Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient).build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MarvelHeroesService = retrofit.create(MarvelHeroesService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: MarvelHeroesImpl): MarvelHeroesHelper = apiHelper
}