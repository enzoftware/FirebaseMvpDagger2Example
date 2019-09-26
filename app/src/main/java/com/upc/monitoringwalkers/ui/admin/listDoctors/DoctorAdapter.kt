package com.upc.monitoringwalkers.ui.admin.listDoctors

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.common.showDeleteAdvertice
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.ui.admin.detailDoctor.DetailDoctorActivity
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
        Glide
            .with(this)
            .load("https://cdn3.iconfinder.com/data/icons/healthcare-medical-lilac-series-vol-1/256/DOCTOR-512.png") // TODO : custom photo
            .centerCrop()
            .placeholder(R.drawable.ic_person_outline_black_24dp)
            .into(img_user_doctor)
        container_item_doctor.setOnClickListener {
            val intent = Intent(context, DetailDoctorActivity::class.java)
            intent.putExtra("doctorId", doctorEntity.id)
            context.startActivity(intent)
        }
    }
}