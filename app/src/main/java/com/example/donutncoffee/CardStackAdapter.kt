package com.example.donutncoffee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.project_card.view.*


class CardStackAdapter(private var projectsList: List<Project>): RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.project_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var project = projectsList[position]
        holder.projectName.text = project.projectName
        holder.projectDesc.text = project.projectDesc
        holder.projectImage.setImageResource(project.projectImg)
    }

    override fun getItemCount(): Int {
        return projectsList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var projectName = view.projectName
        var projectDesc = view.projectDesc
        var projectImage= view.projectImg
    }

}