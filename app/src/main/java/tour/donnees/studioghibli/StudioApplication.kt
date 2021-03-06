package tour.donnees.studioghibli

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import tour.donnees.data.di.dataModule
import tour.donnees.studioghibli.di.studioModule

class StudioApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@StudioApplication)

            modules(listOf(studioModule, dataModule))
        }
    }
}