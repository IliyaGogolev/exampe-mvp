package com.example.mvp.utils

import android.content.Context
import com.example.mvp.features.plan.plandetails.presentation.PlanDetailActivity
import com.example.mvp.features.plan.plans.presentation.PlansActivity

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
object NavigationUtils {

    fun showPlansActivity(context: Context) {
        val intent = PlansActivity.getCallingIntent(context)
        context.startActivity(intent)
    }

    fun showPlanDetailActivity(context: Context, planId:Int) {
        val intent = PlanDetailActivity.getCallingIntent(context, planId)
        context.startActivity(intent)
    }
}