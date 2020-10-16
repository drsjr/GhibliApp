package tour.donnees.studioghibli.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tour.donnees.studioghibli.home.StudioActivityViewModel


val studioModule = module {
    viewModel { StudioActivityViewModel(repository = get()) }
}

