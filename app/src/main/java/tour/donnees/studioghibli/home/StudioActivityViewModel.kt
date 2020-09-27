package tour.donnees.studioghibli.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tour.donnees.studioghibli.dataLayer.model.Film
import tour.donnees.data.repository.GhibliRepository

class StudioActivityViewModel(private val repository: tour.donnees.data.repository.GhibliRepository): ViewModel() {

    val movies = MutableLiveData<List<Film>>()

    fun loadMovies() {
        repository.getFilmAsync().subscribe({ allFilms ->

            val list = allFilms.map { Film(it.id, it.title, it.description) }

            movies.value = list
        }, {
            it.printStackTrace()
        })
    }

}