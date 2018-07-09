package com.example.mvp.features.plan.plans.presentation.presenter

import com.example.mvp.features.plan.plans.domain.GetPlansUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class PlansPresenter
@Inject constructor(private val loadPlans: GetPlansUseCase) : PlansContract.Presenter {

    override lateinit var view: PlansContract.View
    private val compositeDisposable = CompositeDisposable()
    val mapper = PlansToPlansViewDataMapper()

    override fun loadData() {
        compositeDisposable.clear()

        view.showLoading()
        compositeDisposable.add(loadPlans.getPlanList()
                .map(mapper)
                .subscribe({
                    view.hideLoading()
                    view.setData(it)
                }, {
                    view.hideLoading()
                    view.showErrorLoadingFailed()
                }))
    }

    override fun onPlanClicked(planId: Int) {
        view.showPlanDetailsView(planId)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}