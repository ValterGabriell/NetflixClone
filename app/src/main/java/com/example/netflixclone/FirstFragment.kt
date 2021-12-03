package com.example.netflixclone

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Network
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Network.Model.Result
import com.example.netflixclone.Network.Model.ResultX
import com.example.netflixclone.Network.Model.ResultXX
import com.example.netflixclone.Network.NetworkURL
import com.example.netflixclone.View.Activities.MainActivity
import com.example.netflixclone.View.Adapters.ComingSoonAdapter
import com.example.netflixclone.View.Adapters.MyLIstAdapter
import com.example.netflixclone.View.Adapters.NewsWeekAdapter
import com.example.netflixclone.View.Adapters.OnlyNetflixAdapter
import com.example.netflixclone.ViewModel.SharedViewModel
import com.example.netflixclone.databinding.FragmentFirstBinding
import com.squareup.picasso.Picasso

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val model: SharedViewModel by activityViewModels()

    private lateinit var adapterComingSoon: ComingSoonAdapter
    private lateinit var onlyNetflixAdapter: OnlyNetflixAdapter
    private lateinit var newsWeek: NewsWeekAdapter
    private lateinit var myListAdapter: MyLIstAdapter

    private var listaComingSoonMain = ArrayList<ResultX>()
    private var listaComingOnlyNet = ArrayList<ResultXX>()
    private var listanewsWeek = ArrayList<Result>()
    private var listaMyList = ArrayList<MyListModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        model.getOnlyNetflix()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        model.getNewsMovies(binding.layout)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecyclerComingSoon()
        configRecyclerOnlyNetflix()
        configRecyclerNewsWeek()
        changePosterAndSetupClickes()
        configMyListRecycler()
        binding.idProfile.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }




    }

    private fun configMyListRecycler(){

        model.getMoviesFromMyList()
        model.listaMyList.observe(requireActivity(), {
            Log.i("idUser", it.toString())
            listaMyList = it
            listaMyList.reverse()
                if (listaMyList.isNotEmpty()){
                    myListAdapter = MyLIstAdapter(listaMyList)
                    binding.recyclerMyList.adapter = myListAdapter
                    binding.recyclerMyList.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    myListAdapter.onItemClick = {
                        val title = listaMyList[it].titleMovie
                        val poster = listaMyList[it].foto
                        val over = listaMyList[it].overview
                        val date = listaMyList[it].dateRealeased
                        val langague = listaMyList[it].language
                        val action = FirstFragmentDirections.actionFirstFragmentToDetalhesFilmesFragment()

                        action.title = title
                        action.poster = poster
                        action.over = over
                        action.date = date
                        action.lingua = langague

                        findNavController().navigate(action)
                    }

                }else{
                    binding.textView5.visibility = View.GONE
                    binding.recyclerMyList.visibility = View.GONE
                }



        })
    }
    private fun configRecyclerComingSoon() {
        model.getComing()
        model.listaComingSoon.observe(requireActivity(), {
            listaComingSoonMain = it
            adapterComingSoon = ComingSoonAdapter(listaComingSoonMain)
            binding.recyclerViewComingSoon.adapter = adapterComingSoon
            binding.recyclerViewComingSoon.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            adapterComingSoon.onItemClick = {
                val title = listaComingSoonMain[it].title
                val poster = listaComingSoonMain[it].poster_path
                val over = listaComingSoonMain[it].overview
                val date = listaComingSoonMain[it].release_date
                val langague = listaComingSoonMain[it].original_language
                val id = listaComingSoonMain[it].id
                val action = FirstFragmentDirections.actionFirstFragmentToDetalhesFilmesFragment()

                action.title = title
                action.poster = poster
                action.over = over
                action.date = date
                action.lingua = langague
                action.id = id

                findNavController().navigate(action)

            }

        })
    }

    private fun configRecyclerOnlyNetflix() {
        model.getOnlyNetflix()
        model.listaOnlyNet.observe(requireActivity(), {
            listaComingOnlyNet = it
            onlyNetflixAdapter = OnlyNetflixAdapter(listaComingOnlyNet)
            binding.RecyclerViewOnlyNetflix.adapter = onlyNetflixAdapter
            binding.RecyclerViewOnlyNetflix.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            onlyNetflixAdapter.onItemClick = {
                val title = listaComingOnlyNet[it].title
                val poster = listaComingOnlyNet[it].poster_path
                val over = listaComingOnlyNet[it].overview
                val date = listaComingOnlyNet[it].release_date
                val langague = listaComingOnlyNet[it].original_language
                val action = FirstFragmentDirections.actionFirstFragmentToDetalhesFilmesFragment()

                action.title = title
                action.poster = poster
                action.over = over
                action.date = date
                action.lingua = langague

                findNavController().navigate(action)
            }

        })
    }

    private fun configRecyclerNewsWeek() {
        model.getNewsWeek()
        model.listaNewsWeek.observe(requireActivity(), {
            listanewsWeek = it
            newsWeek = NewsWeekAdapter(listanewsWeek)
            binding.RecyclerViewNewsWeek.adapter = newsWeek
            binding.RecyclerViewNewsWeek.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            newsWeek.onItemClick = {
                val title = listanewsWeek[it].title
                val poster = listanewsWeek[it].poster_path
                val over = listanewsWeek[it].overview
                val date = listanewsWeek[it].release_date
                val langague = listanewsWeek[it].original_language
                val action = FirstFragmentDirections.actionFirstFragmentToDetalhesFilmesFragment()

                action.title = title
                action.poster = poster
                action.over = over
                action.date = date
                action.lingua = langague

                findNavController().navigate(action)
            }
        })
    }



    private fun changePosterAndSetupClickes() {
        val action = FirstFragmentDirections.actionFirstFragmentToDetalhesFilmesFragment()

        var idMovie = 0
        var titleMovie = ""
        var dateRealeased = ""
        var language = ""
        var foto = ""
        var overview = ""

        model.imgMovie.observe(requireActivity(), {
            Picasso.get().load(it).into(binding.appBarImage)
            action.poster = it
            foto = it
        })

        model.titleMovie.observe(requireActivity(), {
            action.title = it
            titleMovie = it
            binding.btnPlay.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("${NetworkURL.URL_YT}$titleMovie")))
            }
        })

        model.date.observe(requireActivity(), {
            action.date = it
            dateRealeased = it
        })
        model.langague.observe(requireActivity(), {
            action.lingua = it
            language = it
        })

        model.sinopse.observe(requireActivity(), {
            action.over = it
            overview = it
        })

        model.idFIlmePoster.observe(requireActivity(), {
            action.id = it
            idMovie = it
        })



        binding.btnSibaMais.setOnClickListener {
            findNavController().navigate(action)
        }

        binding.btnMinhaLista.setOnClickListener {

            if (!model.getMoviesFromDatabase(idMovie)){
                Toast.makeText(requireContext(), "Filme adicionado", Toast.LENGTH_SHORT).show()
                val myListModel = MyListModel(
                    idMovie,
                    model.getUserId(),
                    titleMovie,
                    dateRealeased,
                    language,
                    foto,
                    overview,
                    true
                )
                model.addMovieToList(myListModel)
                configMyListRecycler()
                model.getMoviesFromDatabase(idMovie)
            }else{
                Toast.makeText(requireContext(), "Filmes já na sua lista", Toast.LENGTH_SHORT).show()
            }


        }


    }


}