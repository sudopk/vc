package `in`.sudopk.vaishnavacalendar.core

import android.support.annotation.IdRes
import android.view.View


fun <T> View.castViewById(@IdRes id: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById(id) as T
}
