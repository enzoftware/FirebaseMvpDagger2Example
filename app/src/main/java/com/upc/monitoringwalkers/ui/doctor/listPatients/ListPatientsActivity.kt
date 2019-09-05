package com.upc.monitoringwalkers.ui.doctor.listPatients

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.listPatientsPresenter
import kotlinx.android.synthetic.main.activity_list_patients.*

class ListPatientsActivity : AppCompatActivity() {

    private val presenter by lazy { listPatientsPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_patients)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
