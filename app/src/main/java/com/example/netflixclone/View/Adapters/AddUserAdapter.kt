package com.example.netflixclone.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.R
import com.squareup.picasso.Picasso


class AddUserAdapter(val listaUser: ArrayList<UserModel>) :
    RecyclerView.Adapter<AddUserAdapter.UserAdapterViewHolder>() {

    inner class UserAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userModel: UserModel) {

            itemView.findViewById<TextView>(R.id.txtNameAdapterUser).text = userModel.username
            val image = itemView.findViewById<ImageView>(R.id.imgFotoMainRecycler)
            Picasso.get().load(R.drawable.birdorange).into(image)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return UserAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int) {
        holder.bind(listaUser[position])
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }


    }

    override fun getItemCount(): Int {
        return listaUser.size
    }

    var onItemClick: ((Int) -> Unit)? = null

}