package tour.donnees.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import tour.donnees.data.model.FilmResponse

interface GhibliService {

    @GET("/films")
    fun getAllFilms(): Single<List<FilmResponse>>

    @GET("/film/{uuid}")
    fun getAllFilms(@Path("uuid") uuid: String): Single<FilmResponse>
}