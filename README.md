# ScalaTest on Android

Trying to write some Scala using Eclipse and have it run on Android. 

## Steps:

0. Install Eclipse, Android Dev Tools, and AndroidProguardScala plugin
1. Create new Android Application in Eclipse in the normal way.
2. Add Scala Nature to the project (Right click -> Configure -> ...)
3. Add AndroidProguardScala nature
4. Build project (this will create scala\_library.min.jar?)
5. Remove AndroidProguardScala nature
6. Create a run configuration for Android Application
7. Add a Scala class and use it from MainActivity.java
8. Run ("should work")

If you use something in Scala that is not present in scala\_library.min.jar
you'll get a crash. To fix, repeat steps 3, 4, 5 above?

## TODO/ToTry:

1. ~~A Scala class that extends Android.Activity and go to it with an Intent~~
2. ~~MainActivity.scala~~
3. ~~use libGDX~~
3. ~~Test if AndroidProguardScala is compatible with my libGDX
   proguard config.~~ Had to add -libraryjars, -keep, and -dontwarn for Scala
   lib 
4. ~~A Scala class that implements blobengine Game interface and uses blobengine
   classes.~~ See [BalloonPop-Scala](https://github.com/adsgray/BalloonPop-Scala)
5. Incorporating Scaloid? (set up sbt just to get the dependencies)
