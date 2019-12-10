package com.androidacademy.workshop

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.androidacademy.workshop.adapter.MoviesAdapter
import com.androidacademy.workshop.data.Movie
import com.androidacademy.workshop.data.MovieRoomDatabase
import com.androidacademy.workshop.data.Repository
import kotlinx.android.synthetic.main.activity_movies.*


class MoviesFragment : Fragment(), Observer<List<Movie>>, MenuItem.OnMenuItemClickListener {
    private lateinit var movieViewModel: MoviesViewModel

    private lateinit var adapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MoviesAdapter { position -> Unit }
        moviesList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        movieViewModel.observeMovies().observe(viewLifecycleOwner, this)
    }

    override fun onChanged(movies: List<Movie>?) {
        adapter.submitList(movies)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_sort, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        menu.findItem(R.id.menuSort).setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuSort -> {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.flContainer, EditFragment())
                    ?.addToBackStack(null)
                    ?.commit()

                true
            }
            else -> false
        }
    }
}