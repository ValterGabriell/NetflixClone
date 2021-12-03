package com.example.netflixclone.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.Network.Model.ResultX
import com.example.netflixclone.Network.Model.ResultXX
import com.example.netflixclone.R
import com.squareup.picasso.Picasso


class AdapterEditProfile(val listaUser : ArrayList<UserModel>) : RecyclerView.Adapter<AdapterEditProfile.AdapterEditViewHolder>() {

    inner class AdapterEditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(result: UserModel) {
            itemView.findViewById<TextView>(R.id.txtNameAdapterUser).text = result.username
            val image = itemView.findViewById<ImageView>(R.id.imgFotoMainRecycler)
            Picasso.get().load(R.drawable.birdorange).into(image)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterEditViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return AdapterEditViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterEditViewHolder, position: Int) {
            holder.bind(listaUser[position])
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(listaUser[position].id)
            }


    }

    override fun getItemCount(): Int {
        return listaUser.size
    }

    var onItemClick :((Long) -> Unit)? = null

}