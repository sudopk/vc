package `in`.sudopk.vaishnavacalendar.core

import `in`.sudopk.coreandroid.StrFromRes
import android.content.Context
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

fun AppCompatActivity.hasFragmentByTag(tag: String?) = supportFragmentManager.findFragmentByTag(tag).isNotNull()

fun Fragment.hasFragmentByTag(tag: String?) = childFragmentManager.findFragmentByTag(tag).isNotNull()

inline fun <reified T> Fragment.parent() = (parentFragment ?: activity) as T

fun FragmentManager.replace(@IdRes containerId: Int,fragment: Fragment) {
    beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

private class StrFromResImpl(val context: Context) : StrFromRes {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

    override fun getString(resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, formatArgs)
    }
}

val Context.strFromRes : StrFromRes
    get() = StrFromResImpl(applicationContext)

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(msg: String): Unit {
    context.toast(msg)
}
