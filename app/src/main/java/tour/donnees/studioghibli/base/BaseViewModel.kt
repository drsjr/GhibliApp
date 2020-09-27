package tour.donnees.studioghibli.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

abstract  class BaseViewModel: ViewModel() {

    private val disposables = mutableListOf<Disposable>()

    fun addDisposable(disposable: Disposable) {
        this.disposables.add(disposable)
    }

    private fun clearAllDisposable() {
        disposables.map {
            if (!it.isDisposed)
                it.dispose()
        }
        disposables.clear()
    }

    fun getDisposable(): List<Disposable> {
        return disposables
    }

    public override fun onCleared() {
        clearAllDisposable()
        super.onCleared()
    }
}