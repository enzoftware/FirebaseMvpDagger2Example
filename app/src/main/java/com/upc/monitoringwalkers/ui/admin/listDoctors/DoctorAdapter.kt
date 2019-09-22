package com.upc.monitoringwalkers.ui.admin.listDoctors

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.common.showDeleteAdvertice
import com.upc.monitoringwalkers.model.DoctorEntity
import kotlinx.android.synthetic.main.item_doctor.view.*

class DoctorAdapter(private val onDeleteClickHandler: (DoctorEntity) -> Unit) : RecyclerView.Adapter<DoctorHolder>() {

    private val items = mutableListOf<DoctorEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return DoctorHolder(view, onDeleteClickHandler)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DoctorHolder, position: Int) {
        val doctor = items[position]
        holder.displayData(doctor)
    }

    fun setData(data: List<DoctorEntity>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    fun addDoctor(doctorEntity: DoctorEntity) {
        items.add(doctorEntity)
        notifyItemInserted(items.size - 1)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun removeDoctor(doctorEntity: DoctorEntity) {
        items.remove(doctorEntity)
        notifyDataSetChanged()
    }

}

class DoctorHolder(itemView: View, private inline val onDeleteClickHandler: (DoctorEntity) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun displayData(doctorEntity: DoctorEntity) = with(itemView) {
        doctorFullName.text = "${doctorEntity.name}  ${doctorEntity.lastName}"
        doctorEmail.text = doctorEntity.email
        doctor_delete.setOnClickListener {
            showDeleteAdvertice(context) {
                onDeleteClickHandler(doctorEntity)
            }
        }
    }
}