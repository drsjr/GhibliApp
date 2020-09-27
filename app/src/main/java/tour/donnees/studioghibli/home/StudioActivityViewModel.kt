package tour.donnees.studioghibli.home

import androidx.lifecycle.MutableLiveData
import tour.donnees.studioghibli.base.BaseViewModel
import tour.donnees.studioghibli.domain.model.Film

class StudioActivityViewModel(private val repository: tour.donnees.data.repository.GhibliRepository): BaseViewModel() {

    val movies = MutableLiveData<List<Film>>()

    fun loadMovies() {
        addDisposable(repository.getFilmAsync().subscribe({ allFilms ->
            val list = allFilms.map { Film(it.id, it.title, it.description) }
            movies.value = list
        }, {
            it.printStackTrace()
        }))
    }

}