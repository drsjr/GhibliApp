package tour.donnees.studioghibli.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tour.donnees.data.network.RetrofitService
import tour.donnees.data.repository.GhibliRepository
import tour.donnees.studioghibli.home.StudioActivityViewModel


val studioModule = module {

    viewModel {
        StudioActivityViewModel(repository = get())
    }

    factory { GhibliRepository(get()) }

    single { RetrofitService() }
}
