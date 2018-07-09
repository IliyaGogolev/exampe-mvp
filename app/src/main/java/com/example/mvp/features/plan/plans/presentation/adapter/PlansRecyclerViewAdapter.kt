package com.example.mvp.features.plan.plans.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mvp.R
import com.example.mvp.features.plan.plans.presentation.viewData.PlanListItemViewData
import kotlinx.android.synthetic.main.plan_list_item.view.*

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class PlansRecyclerViewAdapter(private val clickListener: View.OnClickListener) :
        RecyclerView.Adapter<PlansRecyclerViewAdapter.ViewHolder>() {

    private var listItems: List<PlanListItemViewData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.plan_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listItems[position]
//        holder.planName.text = item.id.toString()
        holder.planName.text = item.planName
        holder.athleteName.text = item.athleteName

        with(holder.itemView) {
            tag = item
            setOnClickListener(clickListener)
        }
    }

    override fun getItemCount() = listItems.size

    fun setData(list: List<PlanListItemViewData>) {
        listItems = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val planName: TextView = view.planName
        val athleteName: TextView = view.athleteName
    }
}