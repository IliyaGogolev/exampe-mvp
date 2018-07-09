package com.example.mvp.features.plan.plandetails.presentation.presenter

import com.example.mvp.features.plan.plandetails.presentation.viewData.PlanDetailsViewData

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
interface PlanDetailsContract {

    interface Presenter {
        var view: PlanDetailsContract.View

        fun loadPlanDetails(planId: Int)
        fun onCleared()
    }

    interface View {
        fun showLoading()
        fun hideLoading()
        fun setPlanDetails(data: PlanDetailsViewData)
        fun showErrorLoadingFailed()
    }
}