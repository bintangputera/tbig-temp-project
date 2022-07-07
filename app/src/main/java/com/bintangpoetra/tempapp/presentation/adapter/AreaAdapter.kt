package com.bintangpoetra.tempapp.presentation.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bintangpoetra.tempapp.R
import com.bintangpoetra.tempapp.R.string
import com.bintangpoetra.tempapp.data.area.model.AreaItem
import com.bintangpoetra.tempapp.utils.setStatus

class AreaAdapter(private val areaList: List<AreaItem>): RecyclerView.Adapter<AreaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_assignment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        areaList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = areaList.size


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val txAreaName = itemView.findViewById<TextView>(R.id.tv_area_title)
        private val txTagPointsCount = itemView.findViewById<TextView>(R.id.tv_point_tag_counts)
        private val txStatus = itemView.findViewById<TextView>(R.id.tv_status)
        private val parentLayout: ConstraintLayout = itemView.findViewById(R.id.parent_layout)

        fun bind(areaItem: AreaItem) {
            txAreaName.text = areaItem.areaName
            txTagPointsCount.text = itemView.context.getString(string.label_tag_points_counts, areaItem.tagPointsCount.toString())

            txStatus.setStatus(itemView.context, areaItem.completed)

            val statusBg: Int = when(areaItem.completed) {
                true -> R.drawable.bg_complete_assignment_item_border
                false -> R.drawable.bg_uncomplete_assignment_item_border
            }
            parentLayout.background = AppCompatResources.getDrawable(itemView.context, statusBg)

        }
    }

}