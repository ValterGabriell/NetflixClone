package com.example.netflixclone.View.Activities

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.R
import com.example.netflixclone.ViewModel.CreateProfileViewModel
import com.example.netflixclone.databinding.ActivityCreatePerfilBinding


class CreatePerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatePerfilBinding
    private val viewModel: CreateProfileViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_perfil)


        setSupportActionBar(binding.toolbarCreate)
        supportActionBar?.title = "Criar Perfil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addListenerToEditText()

    }

    override fun onStart() {
        super.onStart()
        changeProfilePhoto()
    }

    private fun changeProfilePhoto() {
        binding.imageView2.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.add_photo, null)
            val alert = AlertDialog.Builder(this)
            val alertDialog = alert.create()
            alertDialog.apply {
                setView(view)
                show()
            }
            configView(binding.imageView2, view, alertDialog)
        }
    }

    private fun configView(imageView: ImageView, view: View, alertDialog: AlertDialog) {
        view.run {
            val logogreen = findViewById<ImageView>(R.id.logogreen)
            val logored = findViewById<ImageView>(R.id.logored)
            val logoyellow = findViewById<ImageView>(R.id.logoyellow)
            val birdorange = findViewById<ImageView>(R.id.birdorange)
            val bixoyello = findViewById<ImageView>(R.id.bixoyello)
            val gil = findViewById<ImageView>(R.id.gil)
            val n = findViewById<ImageView>(R.id.n)
            val five = findViewById<ImageView>(R.id.five)
            val woman = findViewById<ImageView>(R.id.woman)

            selectImg(imageView, logogreen, alertDialog)
            selectImg(imageView, logored, alertDialog)
            selectImg(imageView, logoyellow, alertDialog)
            selectImg(imageView, birdorange, alertDialog)
            selectImg(imageView, bixoyello, alertDialog)
            selectImg(imageView, gil, alertDialog)
            selectImg(imageView, n, alertDialog)
            selectImg(imageView, five, alertDialog)
            selectImg(imageView, woman, alertDialog)


        }

    }

    private fun selectImg(imgMain: ImageView, imageView: ImageView, alertDialog: AlertDialog) {
        imageView.setOnClickListener {
            imgMain.setImageDrawable(imageView.drawable)
            alertDialog.dismiss()
        }
    }


    private fun addListenerToEditText() {
        binding.etNameUser.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.toolbarCreate.findViewById<TextView>(R.id.btn_salvar)
                    .setTextColor(Color.GREEN)
            }

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun afterTextChanged(s: Editable?) {

                binding.toolbarCreate.findViewById<TextView>(R.id.btn_salvar).setOnClickListener {
                    if (binding.etNameUser.text.isNotEmpty()) {
                        val userName = binding.etNameUser.text.toString()
                        val imgMain = binding.imageView2.id
                        val swith = binding.switch1.isChecked

                        val userModel = UserModel(0, userName, imgMain, swith)
                        viewModel.addUser(userModel)
                        finish()

                    } else {
                        makeAToast()
                    }
                }
            }

        })

    }


    private fun makeAToast() {
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
    }
}