package tour.donnees.studioghibli.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import tour.donnees.studioghibli.R
import tour.donnees.studioghibli.domain.model.Film

class StudioAdapter: RecyclerView.Adapter<StudioViewHolder>() {

    private val list: ArrayList<Film> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return StudioViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StudioViewHolder, position: Int) {
        val item = list[position]

        holder.title.text = item.title
        holder.year.text = item.description
    }

    fun add(source: List<Film>) {
        list.clear()
        list.addAll(source)
        notifyDataSetChanged()
    }
}

class StudioViewHolder: RecyclerView.ViewHolder {

    var title: TextView
    var year: TextView

    constructor(itemView: View) : super(itemView) {
        title = itemView.name_movie
        year = itemView.year_movie
    }
}