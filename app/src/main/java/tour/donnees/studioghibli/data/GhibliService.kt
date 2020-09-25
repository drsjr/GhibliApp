package tour.donnees.studioghibli.data

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import tour.donnees.studioghibli.data.model.Film

interface GhibliService {

    @GET("/films")
    fun getAllFilms(): Single<List<Film>>

    @GET("/film/{uuid}")
    fun getAllFilms(@Path("uuid") uuid: String): Single<Film>
}