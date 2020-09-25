package tour.donnees.studioghibli.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tour.donnees.studioghibli.data.RetrofitService
import java.lang.reflect.ParameterizedType

open class BaseRepository<E>(private val service: RetrofitService) {

    private fun <E> getEndpoint(endpoint: Class<E>): E {
        return service[endpoint]
    }

    protected fun get(): E {
        return getEndpoint(endpointClass())
    }

    protected fun <T> schedule(single: Single<T>): Single<T> {
        return single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    private fun endpointClass(): Class<E> {
        val clazz: Class<out BaseRepository<*>> = javaClass
        val type = (clazz.genericSuperclass as ParameterizedType).actualTypeArguments
        return type[0] as Class<E>
    }

}