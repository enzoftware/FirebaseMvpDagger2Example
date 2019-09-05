package com.upc.monitoringwalkers.ui.doctor.listPatients

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.model.PatientEntity

class PatientAdapter : RecyclerView.Adapter<PatientHolder>() {

    private val items = mutableListOf<PatientEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_patient, parent, false)
        return PatientHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PatientHolder, position: Int) {
        val patient = items[position]
        holder.displayData(patient)
    }

}

class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun displayData(patient: PatientEntity) {

    }
}