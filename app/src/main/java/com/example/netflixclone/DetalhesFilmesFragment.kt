package com.example.netflixclone

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.netflixclone.Network.NetworkURL
import com.example.netflixclone.databinding.FragmentDetalhesFilmesBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso


class DetalhesFilmesFragment : BottomSheetDialogFragment() {
    private val arguments by navArgs<DetalhesFilmesFragmentArgs>()
    private lateinit var binding: FragmentDetalhesFilmesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes_filmes, container, false)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments.title
        val poster = "https://image.tmdb.org/t/p/w185//${arguments.poster}"
        val date = arguments.date
        val lingua = arguments.lingua
        val over = arguments.over
        val id = arguments.id

        binding.titleFragment.text = title
        binding.overwienFragment.text = over
        binding.anofragment.text = date
        binding.langagueFragmet.text = lingua
        Picasso.get().load(poster).into(binding.imagePosterFragment)

        changeFragment(title, poster, date, over, id)
    }


    private fun changeFragment(
        title: String,
        poster: String,
        date: String,
        over: String,
        id:Int
    ) {
        binding.btnMoreInfo.setOnClickListener {
            val action =
                DetalhesFilmesFragmentDirections.actionDetalhesFilmesFragmentToFilmesFragment()
            action.title = title
            action.poster = poster
            action.date = date
            action.overvien = over
            action.id = id
            findNavController().navigate(action)
        }

        binding.btnAssistirDetalhes.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("${NetworkURL.URL_YT}$title")))
        }
    }




}