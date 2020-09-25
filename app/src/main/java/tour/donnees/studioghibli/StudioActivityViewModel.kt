package tour.donnees.studioghibli

import androidx.lifecycle.MutableLiveData
import tour.donnees.studioghibli.data.model.Film
import tour.donnees.studioghibli.repository.GhibliRepository

class StudioActivityViewModel(private val repository: GhibliRepository) {

    val movies = MutableLiveData<List<Film>>()

    fun loadMovies() {
        repository.getFilmAsync().subscribe({ allFilms ->

            movies.value = allFilms
        }, {
            it.printStackTrace()
        })
    }

}