package com.adsg0186.scalatest

import android.app.Activity
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.ApplicationListener
import android.os.Bundle
import android.content.Context
import com.github.adsgray.gdxtry1.engine.util.GameFactory
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.OrthographicCamera
import android.util.Log
import com.github.adsgray.gdxtry1.engine.output.Renderer
import com.github.adsgray.gdxtry1.engine.input.DefaultDirectionListener
import com.github.adsgray.gdxtry1.engine.input.SimpleDirectionGestureDetector.DirectionListener.FlingInfo
import java.util.Timer
import com.github.adsgray.gdxtry1.engine.util.WorldTickTask
import java.util.TimerTask
import com.badlogic.gdx.Gdx
import com.github.adsgray.gdxtry1.engine.input.SimpleDirectionGestureDetector
import com.badlogic.gdx.graphics.GL10
import com.github.adsgray.gdxtry1.engine.WorldIF

//class GDXActivity extends Activity {
class GDXActivity extends AndroidApplication with ActivityUtil {
  
  //protected val c = getApplicationContext()

  override def onCreate(savedInstanceState:Bundle) = {
    super.onCreate(savedInstanceState)

    // initialize a new instance of your Game class
    initialize(new GDXApp(), false);
  }

  class GDXApp extends ApplicationListener {
    val CAMERA_WIDTH = 800;
	val CAMERA_HEIGHT = 1422;

	// TODO: fix
	var world:WorldIF = null
	var shapes:ShapeRenderer = null
	var batch:SpriteBatch = null
	var camera:OrthographicCamera = null
	var renderer:Renderer = null
	//var renderer:Renderer = null

	def populateWorld = {
	    //GameFactory.populateWorldWithBlobs(world, numBlobs, renderConfig);
	    //GameFactory.populateWorldNonRandom(world, renderConfig);
	    //GameFactory.populateWorldNonRandomBlobSet(world, renderConfig);
	    GameFactory.populateWorldLaunchUp(world, renderer);
	    //GameFactory.populateWorldOoze(world, renderConfig);
	    //GameFactory.populateWorldCollisionTest(world, renderConfig);
	    //GameFactory.populateWorldTestTriggers(world, renderConfig);
	    //GameFactory.populateWorldTestTriggersAgain(world, renderer);
	    //GameFactory.populateWorldGameTestOne(world, renderConfig);
	    //GameFactory.populateWorldTestOffsetPosition(world, renderConfig);
	    //GameFactory.populateWorldTestBumpAccel(world, renderConfig);
	    //GameFactory.populateWorldTestNewBlobSet(world, renderConfig);
	    //GameFactory.populateWorldTestTriangle(world,  renderConfig);
	    //GameFactory.populateWorldTestMultiplyPosition(world,  renderConfig);
	    //GameFactory.populateWorldTestText(world, renderer);
	}

	object testDirectionListener extends DefaultDirectionListener {
	  override def onUp(f:FlingInfo) = {
	    super.onUp(f)
        if (f.startY < 200 && f.velocityY < -800) populateWorld
	  }
	  
	  override def onDown(f:FlingInfo) = {
	    super.onDown(f)
	    if (f.startY > 1000) world.killAllBlobs
	  }
	}

	var worldTimer:Option[Timer] = None
	var worldTick:Option[TimerTask] = None
	
	def startWorldTicker = {
	    // create timer task that will call tick on world every 25 ms

	    worldTimer = worldTimer match {
	      case t @ Some(timer) => t
	      case None => Some(new Timer("worldTickTimer"))
	    }
	    
	    worldTick = worldTick match {
	      case t @ Some(timertask) => t
	      case None => Some(WorldTickTask.createInstance(world))
	    }

	    for {
	      timer <- worldTimer
	      task <- worldTick
	    } yield timer.scheduleAtFixedRate(task, 0, 25)
	}
	
   def create(): Unit = {
     
	shapes = new ShapeRenderer()
	batch = new SpriteBatch()
	camera = new OrthographicCamera()
	camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT); // the camera is like a window into our game world
	Renderer.createRealInstance(shapes, batch)
	renderer = Renderer.getRealInstance
	world = GameFactory.defaultWorld;
     
     Gdx.graphics.setContinuousRendering(false)
     startWorldTicker
     populateWorld
     Gdx.input.setInputProcessor(new SimpleDirectionGestureDetector(camera, testDirectionListener))
   }

   def dispose(): Unit = {
     shapes.dispose
     batch.dispose
     Renderer.get().dispose   
   }

   def pause(): Unit = {
     worldTick map { t => t.cancel }
     worldTimer map { t => t.cancel; t.purge }
     worldTick = None
     worldTimer = None
   }

   def render(): Unit = {
     Gdx.gl.glClearColor(0f, 0f, 0f, 0.4f)
	 Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

	 camera.update
	 batch.setProjectionMatrix(camera.combined)
	 shapes.setProjectionMatrix(camera.combined)
	 world.render
   }

   def resize(x1: Int,x2: Int): Unit = { }

   def resume(): Unit = {
     Log.d("trace", "GameScreen resume");
     worldTimer match {
       case None => startWorldTicker
       case _ => Unit
     }
   }
    
  }
}