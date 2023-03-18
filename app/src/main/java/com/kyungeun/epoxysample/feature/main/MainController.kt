package com.kyungeun.epoxysample.feature.main

import com.airbnb.epoxy.EpoxyController
import com.kyungeun.epoxysample.data.model.Project

class MainController  : EpoxyController() {

    private val itemList = mutableListOf<Project>()

    fun setData(list: List<Project>) {
        itemList.clear()
        itemList.addAll(list)
        requestModelBuild()
    }

    private fun buildItem(project: Project) {
        project.let {
            MainItemViewModel_()
                .id(it.id)
                .project(it)
                .addTo(this)
        }
    }

    override fun buildModels() {
        itemList.forEach { data ->
            buildItem(data)
        }
    }
}



