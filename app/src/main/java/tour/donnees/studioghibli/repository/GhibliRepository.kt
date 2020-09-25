package tour.donnees.studioghibli.repository

import io.reactivex.Single
import tour.donnees.studioghibli.data.GhibliService
import tour.donnees.studioghibli.data.RetrofitService
import tour.donnees.studioghibli.data.model.Film

class GhibliRepository(service: RetrofitService): BaseRepository<GhibliService>(service) {

    fun getFilmAsync(): Single<List<Film>> {
        return schedule(get().getAllFilms())
    }
}