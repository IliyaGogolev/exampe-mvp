package com.example.mvp.features.plan.plandetails.presentation.presenter

import com.example.mvp.features.plan.plandetails.presentation.viewData.PlanDetailsViewData
import com.example.mvp.features.plan.plans.domain.GetPlanDetailsUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
class PlanDetailsPresenter
@Inject constructor(val useCase: GetPlanDetailsUseCase) : PlanDetailsContract.Presenter {

    override lateinit var view: PlanDetailsContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun loadPlanDetails(planId: Int) {

        view.showLoading()
        compositeDisposable.add(
                useCase.getPlanDetails(planId)
                        .map {
                            PlanDetailsViewData(it.name,
                                    it.description,
                                    it.athleteFirstName + " " + it.athleteLastName)
                        }.subscribe({
                                    view.hideLoading()
                                    view.setPlanDetails(it)
                                },
                                {
                                    view.showErrorLoadingFailed()
                                    view.hideLoading()
                                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }


}