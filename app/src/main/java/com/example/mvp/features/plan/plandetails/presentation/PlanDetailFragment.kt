package com.example.mvp.features.plan.plandetails.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mvp.DemoApplication
import com.example.mvp.R
import com.example.mvp.features.plan.plandetails.presentation.presenter.PlanDetailsContract
import com.example.mvp.features.plan.plandetails.presentation.viewData.PlanDetailsViewData
import kotlinx.android.synthetic.main.activity_plan_detail.*
import kotlinx.android.synthetic.main.plan_detail.*
import javax.inject.Inject

/**
 * A fragment representing a single PlanDetails detail screen.
 * This fragment is either contained in a [PlanListActivity]
 * in two-pane mode (on tablets) or a [PlanDetailActivity]
 * on handsets.
 */
class PlanDetailFragment : Fragment(), PlanDetailsContract.View {

    @Inject
    lateinit var presenter: PlanDetailsContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity!!.application as DemoApplication).planComponent.inject(this)
        presenter.view = this

        activity?.toolbar_layout?.title = getString(R.string.title_plan_details)

        arguments?.let {
            if (it.containsKey(ARG_PLAN_ID)) {
                presenter.loadPlanDetails(it.getInt(ARG_PLAN_ID))
            } else {

                Toast.makeText(context, "No plan id!!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plan_detail, container, false)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun setPlanDetails(data: PlanDetailsViewData) {
        activity!!.toolbar_layout?.title = data.name
        plan_detail.text = data.description
    }

    override fun showErrorLoadingFailed() {
        Toast.makeText(context, getString(R.string.error_loading_failed), Toast.LENGTH_LONG).show()
    }

    companion object {
        const val ARG_PLAN_ID = "plan_id"
    }


}
