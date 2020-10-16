package tour.donnees.studioghibli.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.unloadKoinModules
import tour.donnees.studioghibli.R
import tour.donnees.studioghibli.base.BaseActivity
import tour.donnees.studioghibli.base.NetworkState
import tour.donnees.studioghibli.di.studioModule
import tour.donnees.studioghibli.extension.hide
import tour.donnees.studioghibli.extension.show

class StudioActivity : BaseActivity() {

    private val viewModel: StudioActivityViewModel by viewModel()
    private val adapter by lazy { StudioAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observerNetworkState()
        loadObservers()
        loadRecyclerView()
        callMovies()
    }

    override fun observerNetworkState() {
        viewModel.networkState.observe(this, Observer { state ->
            when(state) {
                NetworkState.ERROR -> {
                    progress.hide()
                }

                NetworkState.IDLE -> {
                    progress.hide()
                }

                NetworkState.PROGRESS -> {
                    progress.show()
                }

                NetworkState.SUCCESS -> {
                    progress.hide()
                }
            }
        })
    }

    private fun loadObservers() {
        viewModel.movies.observe(this, Observer {
            adapter.add(it)
        })
    }

    private fun loadRecyclerView() {
        ghibli_recycler_view.let {
            it.layoutManager = LinearLayoutManager(this@StudioActivity, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
        }
    }

    private fun callMovies() {
        viewModel.loadMovies()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
