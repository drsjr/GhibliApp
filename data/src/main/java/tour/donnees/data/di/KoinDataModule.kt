package tour.donnees.data.di

import org.koin.dsl.module
import tour.donnees.data.network.RetrofitService
import tour.donnees.data.repository.GhibliRepository

val dataModule = module {
    single { RetrofitService() }
    single { GhibliRepository(get()) }
}