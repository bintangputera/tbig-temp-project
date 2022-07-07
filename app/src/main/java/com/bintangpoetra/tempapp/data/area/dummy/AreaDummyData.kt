package com.bintangpoetra.tempapp.data.area.dummy

import com.bintangpoetra.tempapp.data.area.model.AreaItem

object AreaDummyData {

    fun getAreaDummyList(): List<AreaItem> = listOf(
        AreaItem(
            areaName = "Ciputat",
            tagPointsCount = 3,
            completed = true
        ),
        AreaItem(
            areaName = "Bekasi",
            tagPointsCount = 2,
            completed = false
        ),
        AreaItem(
            areaName = "Cilacap",
            tagPointsCount = 3,
            completed = true
        ),
        AreaItem(
            areaName = "Gorontalo",
            tagPointsCount = 3,
            completed = true
        ),
    )

}