package egs.data.api

import egs.data.model.MoviesResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("movie/popular")
    suspend fun getMoviesList(
        @QueryMap queryMap: Map<String, String>
    ): Response<MoviesResponseModel>
}