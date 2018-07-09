package com.example.mvp.features.plan.plans.presentation.presenter

import com.example.mvp.features.plan.plans.data.PlanListItem
import com.example.mvp.features.plan.plans.presentation.viewData.PlanListItemViewData
import io.reactivex.functions.Function

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
class PlansToPlansViewDataMapper : Function<List<PlanListItem>, List<PlanListItemViewData>> {
    override fun apply(data: List<PlanListItem>): List<PlanListItemViewData> {

        val list = mutableListOf<PlanListItemViewData>()
        data.forEach {

            list.add(
                    PlanListItemViewData(
                            it.id,
                            it.name,
                            it.athleteFirstName + " " + it.athleteLastName,
                            it.imageSmallUrl
                    ))
        }

        return list

    }
}