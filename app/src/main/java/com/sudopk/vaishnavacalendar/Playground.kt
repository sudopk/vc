package com.sudopk.vaishnavacalendar

import android.arch.lifecycle.*
import android.view.View
import com.sudopk.kandroid.logd
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class UserModel : ViewModel() {
    val userLiveData: LiveData<Any> = object : LiveData<Any>() {}

    fun doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}


class Playground : LifecycleFragment() {
    fun play() {
        val view: View;
        val provider: ViewModelProvider
        val viewModel = ViewModelProviders.of(this).get(UserModel::class.java)
        viewModel.userLiveData.observe(this, Observer<Any> { })
//        findViewById(R.id.button).setOnClickListener(View.OnClickListener { viewModel.doAction() })
    }
}

class MyObserver : LifecycleObserver, AnkoLogger {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        debug("onresume 1");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener2() {
        logd("onresume 2")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        logd("onpause")
    }
}


