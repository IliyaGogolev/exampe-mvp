package com.example.mvp.features.plan.plans.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.mvp.features.plan.plans.presentation.presenter.PlansContract
import com.example.mvp.DemoApplication
import com.example.mvp.R
import com.example.mvp.features.plan.plandetails.presentation.PlanDetailFragment
import com.example.mvp.features.plan.plans.presentation.adapter.PlansRecyclerViewAdapter
import com.example.mvp.features.plan.plans.presentation.viewData.PlanListItemViewData

import com.example.mvp.utils.NavigationUtils
import kotlinx.android.synthetic.main.activity_plan_list.*
import kotlinx.android.synthetic.main.view_plan_list.*
import javax.inject.Inject

/**
 * An activity representing a list of Plans. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [PlanDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class PlansActivity : AppCompatActivity(), PlansContract.View {

    // Whether or not the activity is in two-pane mode,i.e. running on a tablet device.
    private var twoPane: Boolean = false

    @Inject
    lateinit var presenter: PlansContract.Presenter

    companion object {
        fun getCallingIntent(context: Context) = Intent(context, PlansActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as DemoApplication).planComponent.inject(this)

        setContentView(R.layout.activity_plan_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        // plan_detail_container will be present only in the large-screen layouts (res/values-w900dp).
        // If this view is present, then the activity should be in two-pane mode.
        if (plan_detail_container != null) {
            twoPane = true
        }

        setupRecyclerView(plan_list)
        presenter.view = this

        presenter.loadData()

    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val onClickListener = createOnListItemClickListener()
        recyclerView.adapter = PlansRecyclerViewAdapter(onClickListener)
    }

    private fun createOnListItemClickListener(): View.OnClickListener =
            View.OnClickListener { v ->
                val plan = v.tag as PlanListItemViewData
                presenter.onPlanClicked(plan.id)
            }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun setData(list: List<PlanListItemViewData>) {
        (plan_list.adapter as PlansRecyclerViewAdapter).setData(list)
    }

    override fun showPlanDetailsView(planId: Int) {
        if (twoPane) {
            val fragment = PlanDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(PlanDetailFragment.ARG_PLAN_ID, planId)
                }
            }
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.plan_detail_container, fragment)
                    .commit()
        } else {
            NavigationUtils.showPlanDetailActivity(this, planId)
        }
    }

    override fun showErrorLoadingFailed() {
        Toast.makeText(this, getString(R.string.error_loading_failed), Toast.LENGTH_LONG).show()
    }

    override  fun onDestroy() {
        super.onDestroy()
        presenter.onCleared()
    }

}
