package com.upc.monitoringwalkers.ui.base

interface BasePresenter<in T> {
    fun setView(view: T)
}