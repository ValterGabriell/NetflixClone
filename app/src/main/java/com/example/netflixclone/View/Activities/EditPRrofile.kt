package com.example.netflixclone.View.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.R
import com.example.netflixclone.View.Adapters.AdapterEditProfile
import com.example.netflixclone.ViewModel.EditProfileViewModel
import com.example.netflixclone.databinding.ActivityEditPrrofileBinding
import org.koin.android.ext.android.inject

class EditPRrofile : AppCompatActivity() {
    private lateinit var binding : ActivityEditPrrofileBinding
    private lateinit var adapter : AdapterEditProfile
    private var listaProfile = ArrayList<UserModel>()
    private val model by inject<EditProfileViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_prrofile)
        model.getList()
        model.lista.observe(this) {
            listaProfile = it
            adapter = AdapterEditProfile(listaProfile)
            binding.recyclerEdit.adapter = adapter
            binding.recyclerEdit.layoutManager = GridLayoutManager(this, 2)
            adapter.onItemClick = { id ->

                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Deletar perfil")
                alertDialog.setMessage("Você deseja deletar este perfil")
                alertDialog.setPositiveButton("Sim") { dialog, witch ->
                    Toast.makeText(this, "Perfil deletado", Toast.LENGTH_SHORT).show()
                    model.deleteId(id)
                    model.getList()
                }

                alertDialog.setNegativeButton("Não") { dialog, witch ->
                    dialog.dismiss()
                }

                val dialog: AlertDialog = alertDialog.create()
                dialog.show()


            }
        }


    }
}