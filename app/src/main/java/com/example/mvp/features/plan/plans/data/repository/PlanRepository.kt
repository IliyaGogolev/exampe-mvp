package com.example.mvp.features.plan.plans.data.repository

import com.example.mvp.features.plan.net.PlanAPIService
import com.example.mvp.features.plan.plandetails.data.PlanDetails
import com.example.mvp.features.plan.plans.data.PlanListItem
import com.example.mvp.features.plan.plans.data.mapper.PlanDetailsRawMapper
import com.example.mvp.features.plan.plans.data.mapper.PlanListItemRawMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
class PlanRepository
@Inject constructor(private val apiService: PlanAPIService) {

    fun getPlanList(): Single<List<PlanListItem>> =

            apiService.getPlans()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(PlanListItemRawMapper())

    fun getPlanDetails(planId: Int): Single<PlanDetails> =
        apiService.getPlanDetails(planId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PlanDetailsRawMapper())
}