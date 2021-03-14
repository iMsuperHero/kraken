package com.cornerjob.marvelheroes.presentation.util

import android.app.Activity
import android.content.Intent
import androidx.core.view.ViewCompat
import android.view.View
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import com.cornerjob.marvelheroes.presentation.heroedetail.MarvelHeroDetailActivity
import com.cornerjob.marvelheroes.domain.model.Result

object Navigator {
    fun goToHeroDetail(activity: Activity, hero: Result, image: View) {
        val options = makeSceneTransitionAnimation(activity, image,
                ViewCompat.getTransitionName(image)!!)
        val intent = Intent(activity, MarvelHeroDetailActivity::class.java).apply {
            putExtra(MarvelHeroDetailActivity.PARAM_HERO, hero)
        }
        activity.startActivity(intent, options.toBundle())
    }

}