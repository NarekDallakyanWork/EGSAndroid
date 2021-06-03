package egs.data.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import egs.data.api.ApiService
import egs.data.base.NetworkConstant
import egs.data.repository.MoviesRepositoryImpl
import egs.domain.repository.MoviesRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(NetworkConstant.Url.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun bindMoviesRepository(apiService: ApiService): MoviesRepository {
        return MoviesRepositoryImpl(apiService)
    }
}