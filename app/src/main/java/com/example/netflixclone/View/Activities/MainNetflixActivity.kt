package com.example.netflixclone.View.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.R
import com.example.netflixclone.databinding.ActivityMainBinding
import com.example.netflixclone.databinding.ActivityMainNetflixBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainNetflixActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainNetflixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_netflix)

    }
}