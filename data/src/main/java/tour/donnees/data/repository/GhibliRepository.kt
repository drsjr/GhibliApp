package tour.donnees.data.repository

import io.reactivex.Single
import tour.donnees.data.api.GhibliService
import tour.donnees.data.model.FilmResponse
import tour.donnees.data.network.RetrofitService

class GhibliRepository(service: RetrofitService): BaseRepository<GhibliService>(service) {

    fun getFilmAsync(): Single<List<FilmResponse>> {
        return schedule(get().getAllFilms())
    }
}