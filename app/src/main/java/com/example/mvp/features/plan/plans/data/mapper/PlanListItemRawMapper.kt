package com.example.mvp.features.plan.plans.data.mapper

import com.example.mvp.features.plan.plandetails.data.PlanDetails
import com.example.mvp.features.plan.plandetails.data.raw.PlanDetailsRaw
import com.example.mvp.net.BaseResponse
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/29/18.
 */

class PlanDetailsRawMapper

@Inject internal constructor() : Function<BaseResponse<PlanDetailsRaw>, PlanDetails> {
    override fun apply(data: BaseResponse<PlanDetailsRaw>): PlanDetails {

        val raw = data.result!!

        return PlanDetails(
                raw.id,
                raw.name,
                raw.description,
                raw.athleteFirstName,
                raw.athleteLastName,
                raw.imageUrl
                )
    }
}
