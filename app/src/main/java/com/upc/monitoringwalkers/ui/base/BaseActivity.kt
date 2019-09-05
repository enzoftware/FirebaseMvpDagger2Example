package com.upc.monitoringwalkers.ui.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.upc.monitoringwalkers.R
import de.mrapp.android.dialog.ProgressDialog

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print("Welcome")

    }

    fun setFullScreenMode() {
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }


    fun showLoadingDialog() {
        val dialogBuilder = ProgressDialog.Builder(this)
        dialogBuilder.setTitle(getString(R.string.please_wait_txt))
        dialogBuilder.setMessage(getString(R.string.loading_txt))
        dialogBuilder.setProgressBarPosition(ProgressDialog.ProgressBarPosition.LEFT)
        progressDialog = dialogBuilder.create()
        progressDialog.show()
    }

    fun hideLoadingDialog() {
        progressDialog.hide()
    }
}