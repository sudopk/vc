package com.sudopk.vaishnavacalendar

import android.support.design.widget.Snackbar
import android.view.View
import android.R.attr.button
import android.arch.lifecycle.*
import android.support.v4.app.Fragment

class UserModel: ViewModel() {
    val userLiveData: LiveData<Any> = object : LiveData<Any>() {}

    fun doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}


class Playground: LifecycleFragment() {
    fun play() {
        val view: View;
        val provider: ViewModelProvider
        val viewModel = ViewModelProviders.of(this).get(UserModel::class.java)
        viewModel.userLiveData.observe(this, Observer<Any> { })
//        findViewById(R.id.button).setOnClickListener(View.OnClickListener { viewModel.doAction() })
    }
}

