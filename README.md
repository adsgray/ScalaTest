# ScalaTest on Android

Trying to write some Scala using Eclipse code and have it run on Android. 

Steps:

0. Install Eclipse, Android Dev Tools, and AndroidProguardScala plugin
1. Create new Android Application in Eclipse in the normal way.
2. Add Scala Nature to the project (Right click -> Configure -> ...)
3. DO NOT yet add AndroidProguardScala nature
4. Create a run configuration for Android Application
5. Add a Scala class and use it from MainActivity.java
6. Run ("should work")

Now you can add AndroidProguardScala nature and build again. It takes a while.


TODO/ToTry:
1. A Scala class that extends Android.Activity and go to it with an Intent
2. Incorporating Scaloid? (set up sbt just to get the dependencies)
3. A Scala class that implements blobengine Game interface and uses blobengine
   classes.
