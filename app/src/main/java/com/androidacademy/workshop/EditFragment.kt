package com.androidacademy.workshop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.androidacademy.workshop.data.Repository
import kotlinx.android.synthetic.main.fragment_edit.*


class EditFragment : Fragment(), View.OnClickListener {

    private lateinit var movieViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.run {
            movieViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        }
        rgSorting.children.forEach {
            it.setOnClickListener(this)
        }
        movieViewModel.loadMovies()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.rBtnSortName -> {
                movieViewModel.sortByName()
            }
            R.id.rBtnSortDate -> {
                movieViewModel.sortByReleaseDate()
            }
            R.id.rBtnSortOverview -> {
                movieViewModel.sortByOverview()
            }
        }
    }
}