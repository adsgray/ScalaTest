package com.adsg0186.scalatest

import android.widget.Button
import android.view.View.OnClickListener
import android.content.Context
import android.view.View
import android.widget.Toast
import java.util.Random

// I can see why Scaloid made Context an implicit parameter.
object ClickListener {
  def apply(f:View => Unit, c:Context) = new OnClickListener() {
      @Override def onClick(v:View) = f(v)
  }
}

object ToastMessage {
  lazy val rnd = new Random()
  val messages = List("one", "two", "three")
  def message = messages(rnd.nextInt(messages.length))
  
  def makeToastButton(b:Button, c:Context) = {
    b.setOnClickListener(new OnClickListener() {
      @Override def onClick(v:View) = Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    })
    b
  }
  
  def makeToastButton2(b:Button, c:Context) = 
    b.setOnClickListener(ClickListener({ v => Toast.makeText(c, message, Toast.LENGTH_SHORT).show() }, c))
}

class Util {

}