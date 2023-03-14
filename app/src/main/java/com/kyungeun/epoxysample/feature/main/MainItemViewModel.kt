package com.kyungeun.epoxysample.feature.main

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyDataBindingLayouts
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.kyungeun.epoxysample.R
import com.kyungeun.epoxysample.data.model.Project
import com.kyungeun.epoxysample.databinding.ItemProjectBinding

@EpoxyModelClass(layout = R.layout.item_project)
abstract class MainItemViewModel : EpoxyModelWithHolder<MainItemViewModel.MainItemViewHolder>() {

    private var binding: ItemProjectBinding? = null

    @EpoxyAttribute
    lateinit var project: Project

    override fun bind(holder: MainItemViewHolder) {
        binding = ItemProjectBinding.bind(holder.itemView)
        binding!!.tvName.text = project.name
        binding!!.tvDescription.text = project.description
    }

    override fun unbind(holder: MainItemViewHolder) {
        binding = null
    }

    inner class MainItemViewHolder : EpoxyHolder() {
        lateinit var itemView: View
        override fun bindView(itemView: View) {
            this.itemView = itemView
        }
    }
}

