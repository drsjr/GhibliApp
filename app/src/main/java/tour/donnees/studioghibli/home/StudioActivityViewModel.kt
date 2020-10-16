package tour.donnees.studioghibli.home

import androidx.lifecycle.MutableLiveData
import tour.donnees.data.repository.GhibliRepository
import tour.donnees.studioghibli.base.BaseViewModel
import tour.donnees.studioghibli.base.NetworkState
import tour.donnees.studioghibli.domain.model.Film

open class StudioActivityViewModel(private val repository: GhibliRepository): BaseViewModel() {

    val movies = MutableLiveData<List<Film>>()
    val networkState = MutableLiveData<NetworkState>()

    fun loadMovies() {
        networkState.value = NetworkState.PROGRESS
        addDisposable(repository.getFilmAsync().subscribe({ allFilms ->
            val list = allFilms.map { Film(it.id, it.title, it.description) }
            movies.value = list
            networkState.value = NetworkState.SUCCESS
        }, {
            it.printStackTrace()
        }))
    }

}