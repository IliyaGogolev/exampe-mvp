package com.example.mvp.features.plan.di

import com.example.mvp.di.AppComponent
import com.example.mvp.features.plan.plandetails.presentation.PlanDetailFragment
import com.example.mvp.features.plan.plans.presentation.PlansActivity
import dagger.Component

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
@PlanScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(PlanDataModule::class, PlanViewModel::class))
interface PlanComponent {

    fun inject(activity: PlansActivity)
    fun inject(fragment: PlanDetailFragment)
}
