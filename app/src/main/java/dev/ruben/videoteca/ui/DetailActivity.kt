package dev.ruben.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.ruben.videoteca.R
import dev.ruben.videoteca.model.Movie
import dev.ruben.videoteca.utils.loadImage


import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        retrieveMovie()
        renderUi()
    }

    private fun retrieveMovie() {
        movie = intent.getSerializableExtra("movie") as Movie?
    }

    private fun renderUi() {
        detailName.text = movie?.name
        detailDescription.text = movie!!.description
        movie?.cover?.let { mCover ->
            detailImage.loadImage(mCover)
        }
    }
}