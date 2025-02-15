package com.cornerjob.marvelheroes.presentation.heroedetail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cornerjob.marvelheroes.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hero_detail.*
import com.cornerjob.marvelheroes.domain.model.Result

@AndroidEntryPoint
class MarvelHeroDetailActivity : AppCompatActivity() {
    companion object {
        const val PARAM_HERO = "hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
        supportPostponeEnterTransition() // Wait for image load and then draw the animation

        val hero: Result? = intent?.extras?.getParcelable(PARAM_HERO)
        hero?.let { fillHeroData(it) }
    }

    private fun fillHeroData(hero: Result) {
        Glide.with(this)
                .load(hero.thumbnail.path + "." + hero.thumbnail.extension)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }
                })
                .into(heroDetailImage)

        heroDetailName.text = hero.name
        heroDetailDescription.text = hero.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}