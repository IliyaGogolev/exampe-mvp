package com.example.mvp.features.plan.plans.domain

import com.example.mvp.features.plan.plans.data.PlanListItem
import com.example.mvp.features.plan.plans.data.repository.PlanRepository
import io.reactivex.Single

/**
 * This class responsible for business logic of plan
 * Created by Iliya Gogolev on 6/28/18.
 */
class GetPlansUseCase (private val repository:PlanRepository) {

    fun getPlanList() : Single<List<PlanListItem>> = repository.getPlanList()
}