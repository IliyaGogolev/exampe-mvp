package com.example.mvp.features.plan.plans.presentation.presenter

import com.example.mvp.features.plan.plans.presentation.viewData.PlanListItemViewData

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
interface PlansContract {

    interface Presenter {
        var view: PlansContract.View

        fun loadData()
        fun onPlanClicked(planId: Int)
        fun onCleared()
    }

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showErrorLoadingFailed()
        fun setData(list: List<PlanListItemViewData>)
        fun showPlanDetailsView(planId: Int)
    }
}