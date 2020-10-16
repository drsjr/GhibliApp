package tour.donnees.studioghibli.movie

import android.os.Bundle
import tour.donnees.studioghibli.R
import tour.donnees.studioghibli.base.BaseActivity

class MovieActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
    }

    override fun observerNetworkState() {

    }
}