package com.upc.monitoringwalkers.ui.register

import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.registerPresenter
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.register.view.RegisterView

class RegisterActivity : BaseActivity(), RegisterView {

    private val presenter by lazy { registerPresenter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onRegisterSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSignUpError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUsernameError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordMatchingError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
