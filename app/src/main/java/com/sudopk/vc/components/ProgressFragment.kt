package com.sudopk.vc.components

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sudopk.kandroid.appCompatActivity
import com.sudopk.vc.R
import org.jetbrains.anko.find

class ProgressFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.progress, container, false)

        appCompatActivity.setSupportActionBar(view.find(R.id.toolbar))

        return view
    }
}

class ToolbarFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.container_with_toolbar, container, false)

        appCompatActivity.setSupportActionBar(view.find(R.id.toolbar))

        return view
    }
}

