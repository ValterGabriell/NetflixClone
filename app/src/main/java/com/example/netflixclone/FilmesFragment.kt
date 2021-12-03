package com.example.netflixclone

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Network.Model.ResultX
import com.example.netflixclone.Network.NetworkURL
import com.example.netflixclone.View.Adapters.ComingSoonAdapter
import com.example.netflixclone.ViewModel.SharedViewModel
import com.example.netflixclone.databinding.FragmentFilmesBinding
import com.squareup.picasso.Picasso

class FilmesFragment : Fragment() {

    private val arguments by navArgs<FilmesFragmentArgs>()
    private lateinit var binding: FragmentFilmesBinding
    private val model: SharedViewModel by activityViewModels()
    private lateinit var adapterComingSoon: ComingSoonAdapter
    private var listaComingSoonMain = ArrayList<ResultX>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filmes, container, false)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments.title
        val poster = "https://image.tmdb.org/t/p/w185//${arguments.poster}"
        val date = arguments.date
        val over = arguments.overvien
        val id = arguments.id
        val language = arguments.language

        binding.txtTitleFina.text = title
        binding.txtOverView.text = over
        binding.txtDate.text = date
        Picasso.get().load(poster).into(binding.imgPOsterMai)


        changeButtonWhenAddToMyList(id)
        setBtnToWatchTrailer(title)
        addMovieToMyList(title, date, language, poster, over, id)
        configRecycler()


    }

    private fun changeButtonWhenAddToMyList(id:Int){
        if (model.getMoviesFromDatabase(id)){
            binding.btnSaveToMyList.apply {
                text = "Na sua lista!"
                setBackgroundColor(Color.RED)
            }

        }
    }

    private fun configRecycler() {
        model.getComing()
        model.listaComingSoon.observe(requireActivity(), {
            listaComingSoonMain = it
            adapterComingSoon = ComingSoonAdapter(listaComingSoonMain)
            binding.recyclerOpceossEME.adapter = adapterComingSoon
            binding.recyclerOpceossEME.layoutManager =
                GridLayoutManager(context, 3)

            adapterComingSoon.onItemClick = {
                val title = listaComingSoonMain[it].title
                val poster = listaComingSoonMain[it].poster_path
                val over = listaComingSoonMain[it].overview
                val date = listaComingSoonMain[it].release_date
                val langague = listaComingSoonMain[it].original_language
                val action = FilmesFragmentDirections.actionFilmesFragmentToDetalhesFilmesFragment()

                action.title = title
                action.poster = poster
                action.over = over
                action.date = date
                action.lingua = langague

                findNavController().navigate(action)

            }

        })
    }

    private fun addMovieToMyList(
        title: String,
        date: String,
        language: String,
        poster: String,
        over: String,
        ids: Int
    ) {

        binding.btnSaveToMyList.setOnClickListener {
            if (!model.getMoviesFromDatabase(ids)){
                val myListModel = MyListModel(
                    ids,
                    model.getUserId(),
                    title,
                    date,
                    language,
                    poster,
                    over,
                    true
                )
                model.addMovieToList(myListModel)
                Toast.makeText(requireContext(), "Filmes adicionado", Toast.LENGTH_SHORT).show()
                binding.btnSaveToMyList.apply {
                    text = "Na sua lista!"
                    setBackgroundColor(Color.RED)
                }
            }else{
                Toast.makeText(requireContext(), "Filme já adicionado à sua lista", Toast.LENGTH_SHORT).show()
            }



        }
    }

    private fun setBtnToWatchTrailer(title: String) {
        binding.btnWatch.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("${NetworkURL.URL_YT}$title")))
        }
    }


}