package com.jetpack.compose.news.di

import android.app.Application
import com.jetpack.compose.news.data.manager.LocalUserManagerImp
import com.jetpack.compose.news.data.remote.NewsAPI
import com.jetpack.compose.news.data.repository.NewsRepositoryImp
import com.jetpack.compose.news.domain.manager.LocalUserManager
import com.jetpack.compose.news.domain.repository.NewsRepository
import com.jetpack.compose.news.domain.usecases.AppEntryUseCases
import com.jetpack.compose.news.domain.usecases.GetNews
import com.jetpack.compose.news.domain.usecases.NewsUseCases
import com.jetpack.compose.news.domain.usecases.ReadAppEntry
import com.jetpack.compose.news.domain.usecases.SaveAppEntry
import com.jetpack.compose.news.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )


    @Provides
    @Singleton
    fun provideApiInstance(): NewsAPI {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsAPI
    ): NewsRepository {
        return NewsRepositoryImp(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}