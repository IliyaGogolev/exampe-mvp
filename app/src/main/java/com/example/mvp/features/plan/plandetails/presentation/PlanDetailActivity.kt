package com.example.mvp.features.plan.plandetails.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.mvp.R
import com.example.mvp.features.plan.plans.presentation.PlansActivity
import kotlinx.android.synthetic.main.activity_plan_detail.*

/**
 * An activity representing a single PlanDetails detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [PlansActivity].
 */
class PlanDetailActivity : AppCompatActivity() {

    companion object {
        fun getCallingIntent(context: Context, planId: Int): Intent =
            Intent(context, PlanDetailActivity::class.java).apply {
                putExtra(PlanDetailFragment.ARG_PLAN_ID, planId)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = PlanDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(PlanDetailFragment.ARG_PLAN_ID,
                            intent.getIntExtra(PlanDetailFragment.ARG_PLAN_ID, 0))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.plan_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
}
