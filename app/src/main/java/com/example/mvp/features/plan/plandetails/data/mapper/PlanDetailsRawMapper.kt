package com.example.mvp.features.plan.plans.data.mapper

import com.example.mvp.features.plan.plans.data.PlanListItem
import com.example.mvp.features.plan.plans.data.raw.PlanListItemRaw
import com.example.mvp.net.BaseResponse
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/29/18.
 */

class PlanListItemRawMapper
@Inject internal constructor() : Function<BaseResponse<List<PlanListItemRaw>>, List<PlanListItem>> {
    override fun apply(response: BaseResponse<List<PlanListItemRaw>>): List<PlanListItem> {

        val result = response.result

        val list = mutableListOf<PlanListItem>()
        result?.forEach {

            list.add(
                    PlanListItem(
                            it.id,
                            it.name,
                            it.athleteFirstName,
                            it.athleteLastName,
                            it.imageUrl,
                            it.imageSmallUrl
                    ))
        }

        return list

    }
}
