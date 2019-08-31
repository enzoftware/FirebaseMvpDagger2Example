package com.upc.monitoringwalkers.ui.login

import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.loginPresenter
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.login.view.LoginView

class LoginActivity : BaseActivity(), LoginView {

    private val presenter by lazy { loginPresenter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Initialize the view
        presenter.setView(this)

        initUi()
    }

    private fun initUi() {
        print("Hello world")
    }

    //region View Callbacks

    override fun onLoginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //endregion
}
