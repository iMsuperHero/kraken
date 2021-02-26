package com.cornerjob.marvelheroes.presentation.util

import android.app.Activity
import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import android.view.View
import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import com.cornerjob.marvelheroes.presentation.heroedetail.MarvelHeroDetailActivity

class Navigator {

    fun goToHeroDetail(activity: Activity, hero: MarvelHeroEntity, image: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, image,
                ViewCompat.getTransitionName(image)!!)
        val intent = Intent(activity, MarvelHeroDetailActivity::class.java).apply {
            putExtra(MarvelHeroDetailActivity.PARAM_HERO, hero)
        }

        activity.startActivity(intent, options.toBundle())
    }

}