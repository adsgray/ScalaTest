package com.adsg0186.scalatest

import android.app.Activity
import android.os.Bundle
import com.adsg0186.scalatest.implicitOps._
import android.widget.Button


class TestActivity extends Activity with ActivityUtil {

  override def onCreate(savedInstanceState:Bundle) = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_test)
  }
}