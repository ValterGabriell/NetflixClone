package com.example.netflixclone.View.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netflixclone.FilmesFragment
import com.example.netflixclone.FirstFragment
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.R
import com.example.netflixclone.View.Adapters.AddUserAdapter
import com.example.netflixclone.ViewModel.MainViewModel
import com.example.netflixclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listaUsers = ArrayList<UserModel>()
    private lateinit var adapterUser: AddUserAdapter
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NetflixClone)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbarmain)


        binding.toolbarmain.findViewById<ImageView>(R.id.id_edit_img_main).setOnClickListener {
            startActivity(Intent(this, EditPRrofile::class.java))
        }




        createProfile()
    }

    override fun onResume() {
        super.onResume()
        configRv()
    }


    private fun configRv() {
        model.getUsers()



        model.listUsers.observe(this) { array ->
            listaUsers = array
            adapterUser = AddUserAdapter(listaUsers)
            binding.rvUsers.adapter = adapterUser
            binding.rvUsers.layoutManager =
                GridLayoutManager(this, 2)

            adapterUser.onItemClick = {
                startActivity(Intent(this, MainNetflixActivity::class.java))
            }

            if (adapterUser.listaUser.isEmpty()) {
                binding.textView3.text = "Crie seu primeiro perfil!"
            } else {
                binding.textView3.text = "Quem irá assistir?"
            }
        }

    }

    private fun createProfile() {


        binding.imgAddPerfil.setOnClickListener {
            if (adapterUser.listaUser.size >= 5) {
                Toast.makeText(this, "Número limites de perfis", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, CreatePerfilActivity::class.java))
            }
        }

    }

}