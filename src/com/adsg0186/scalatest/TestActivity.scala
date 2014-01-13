package com.adsg0186.scalatest

import android.app.Activity
import android.os.Bundle

class TestActivity extends Activity {

  override def onCreate(savedInstanceState:Bundle) = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_test)
  }
}