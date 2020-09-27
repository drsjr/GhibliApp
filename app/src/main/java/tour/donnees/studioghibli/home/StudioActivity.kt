package tour.donnees.studioghibli.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import tour.donnees.studioghibli.R

class StudioActivity : AppCompatActivity() {

    private val viewModel: StudioActivityViewModel by viewModel()
    private val adapter by lazy { StudioAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadObservers()
        loadRecyclerView()
        viewModel.loadMovies()
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
}
