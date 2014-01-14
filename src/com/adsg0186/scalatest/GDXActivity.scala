package com.adsg0186.scalatest

import android.app.Activity
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.ApplicationListener
import android.os.Bundle

//class GDXActivity extends Activity {
class GDXActivity extends AndroidApplication with ActivityUtil {
  
  override def onCreate(savedInstanceState:Bundle) = {
    super.onCreate(savedInstanceState)
    
  }

  class GDXApp extends ApplicationListener {
    
   def create(): Unit = ??? 
   def dispose(): Unit = ??? 
   def pause(): Unit = ??? 
   def render(): Unit = ??? 
   def resize(x$1: Int,x$2: Int): Unit = ??? 
   def resume(): Unit = ???
    
  }
}