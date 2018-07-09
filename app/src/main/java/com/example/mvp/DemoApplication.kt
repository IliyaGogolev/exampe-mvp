package com.example.mvp

import android.app.Application
import com.example.mvp.di.AppComponent
import com.example.mvp.di.DaggerAppComponent
import com.example.mvp.features.plan.di.DaggerPlanComponent
import com.example.mvp.features.plan.di.PlanComponent

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class DemoApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .build()
    }

    val planComponent: PlanComponent by lazy {
        DaggerPlanComponent
                .builder()
                .appComponent(appComponent)
                .build()
    }

}
