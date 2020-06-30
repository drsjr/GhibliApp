package tour.donnees.studioghibli.data

import retrofit2.http.GET
import retrofit2.http.Path
import tour.donnees.studioghibli.data.model.Film

interface Service {

    @GET("/film")
    fun getAllFilms(): Collection<Film>

    @GET("/film/{uuid}")
    fun getAllFilms(@Path("uuid") uuid: String): Film
}