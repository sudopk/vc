package com.sudopk.vc.components

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.annotation.RequiresApi


class SimpleList : LinearLayout {
  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  constructor(
    context: Context, attrs: AttributeSet, defStyleAttr: Int,
    defStyleRes: Int
  ) : super(context, attrs, defStyleAttr, defStyleRes) {
  }

  //TODO: notifydatasetchanged of adapter won't work right now
  fun setAdapter(adapter: Adapter) {
    removeAllViews()
    val count = adapter.count
    for (i in 0..count - 1) {
      addView(adapter.getView(i, null, this))
    }
  }

}
