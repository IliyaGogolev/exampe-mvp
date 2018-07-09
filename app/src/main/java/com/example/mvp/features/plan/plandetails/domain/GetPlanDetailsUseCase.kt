package com.example.mvp.features.plan.plans.domain

import com.example.mvp.features.plan.plandetails.data.PlanDetails
import com.example.mvp.features.plan.plans.data.repository.PlanRepository
import io.reactivex.Single

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class GetPlanDetailsUseCase(private val repository: PlanRepository) {

    fun getPlanDetails(planId: Int): Single<PlanDetails> {
        return repository.getPlanDetails(planId)
    }
}