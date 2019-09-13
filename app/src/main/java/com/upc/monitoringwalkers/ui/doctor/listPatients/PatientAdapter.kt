package com.upc.monitoringwalkers.ui.doctor.listPatients

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.model.PatientEntity
import kotlinx.android.synthetic.main.item_patient.view.*

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

    fun addPatient(patient: PatientEntity) {
        items.add(patient)
        notifyItemInserted(items.size - 1)
    }
}

class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun displayData(patient: PatientEntity) = with(itemView) {
        patientFullName.text = "${patient.name} ${patient.lastName}"
        patientEmail.text = patient.email
    }
}