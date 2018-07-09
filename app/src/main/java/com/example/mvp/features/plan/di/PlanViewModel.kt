package com.example.mvp.features.plan.di

import com.example.mvp.features.plan.plandetails.presentation.presenter.PlanDetailsContract
import com.example.mvp.features.plan.plandetails.presentation.presenter.PlanDetailsPresenter
import com.example.mvp.features.plan.plans.domain.GetPlanDetailsUseCase
import com.example.mvp.features.plan.plans.domain.GetPlansUseCase
import com.example.mvp.features.plan.plans.presentation.presenter.PlansContract
import com.example.mvp.features.plan.plans.presentation.presenter.PlansPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Iliya Gogolev on 12/18/17.
 */
@Module
class PlanViewModel {

    @Provides
    fun providePlanPresenter(useCase: GetPlansUseCase): PlansContract.Presenter = PlansPresenter(useCase)

    @Provides
    fun providePlanDetailsPresenter(useCase: GetPlanDetailsUseCase): PlanDetailsContract.Presenter = PlanDetailsPresenter(useCase)
}
