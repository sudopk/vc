package `in`.sudopk.vaishnavacalendar.core

import java.lang.ref.WeakReference

data class Mortal<T>(var callback: T?) {
    fun die() {
        callback = null
    }
}

val <T> WeakReference<T>.get
    get() = get()

val <T> T.weak
    get() = WeakReference(this)

