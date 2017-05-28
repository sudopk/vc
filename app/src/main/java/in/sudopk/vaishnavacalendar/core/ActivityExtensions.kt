package `in`.sudopk.vaishnavacalendar.core

import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.hasFragmentByTag(tag: String?) = supportFragmentManager
        .findFragmentByTag(tag) != null
