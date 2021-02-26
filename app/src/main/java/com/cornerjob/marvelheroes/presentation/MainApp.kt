package com.cornerjob.marvelheroes.presentation

import android.app.Application
import com.cornerjob.marvelheroes.di.components.ApplicationComponent
import com.cornerjob.marvelheroes.di.components.DaggerApplicationComponent
import com.cornerjob.marvelheroes.di.modules.ApplicationModule

class MainApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}