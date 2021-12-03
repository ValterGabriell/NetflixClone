package com.example.netflixclone.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.Network.Model.ComingSoon
import com.example.netflixclone.Network.Model.Result
import com.example.netflixclone.Network.Model.ResultX
import com.example.netflixclone.R
import com.squareup.picasso.Picasso


class NewsWeekAdapter(val listaUser : ArrayList<Result>) : RecyclerView.Adapter<NewsWeekAdapter.ComingSoonViewHolder>() {

    inner class ComingSoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(result: Result) {
            val img = "https://image.tmdb.org/t/p/w185//${result.poster_path}"
            val poster = itemView.findViewById<ImageView>(R.id.imgPosterView)
            Picasso.get().load(img).into(poster)

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_comingsoons, parent, false)
        return ComingSoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComingSoonViewHolder, position: Int) {
            holder.bind(listaUser[position])
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(position)
            }


    }

    override fun getItemCount(): Int {
        return listaUser.size
    }

    var onItemClick :((Int) -> Unit)? = null

}