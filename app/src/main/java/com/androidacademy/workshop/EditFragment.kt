package com.androidacademy.workshop

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rgSorting.children
            .forEach { view -> view.setOnClickListener(this) }
    }

    override fun onClick(view: View) {
        when (view.id) {
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