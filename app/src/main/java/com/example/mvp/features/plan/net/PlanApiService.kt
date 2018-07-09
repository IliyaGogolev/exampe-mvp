package com.example.mvp.features.plan.net

import com.example.mvp.features.plan.plandetails.data.raw.PlanDetailsRaw
import com.example.mvp.features.plan.plans.data.raw.PlanListItemRaw
import com.example.mvp.net.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
interface PlanAPIService {

    @GET("/archdemo/plans")
    fun getPlans(): Single<BaseResponse<List<PlanListItemRaw>>>

    @GET("/archdemo/plan/details?")
    fun getPlanDetails(@Query("planId") planId: Int): Single<BaseResponse<PlanDetailsRaw>>
}