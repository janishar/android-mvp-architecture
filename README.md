# Android MVP Architecture: Sample App
[![Mindorks](https://img.shields.io/badge/mindorks-opensource-blue.svg)](https://mindorks.com/open-source-projects)

This repository contains a detailed sample app that implements MVP architecture using Dagger2, GreenDao, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase
<p align="center">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-login.png" width="250">
  <img src="https://janishar.github.io/images/mvp-app-pics/main-view.png" width="250">
  <img src="https://janishar.github.io/gifs/mvp-app.gif" width="250">
</p>
<br>
<br>
# Architecture Blueprint
![Blueprint](https://janishar.github.io/images/mvp-app-pics/mvp-arch.png)
<br>
# Project Structure
![Structure](https://janishar.github.io/images/mvp-app-pics/mvp-project-structure-diagram.png)
<br>

# Read the below listed articles. They describe the MVP concepts and the Project structure.
1. [MVP: Part 1](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-1-74efaf1cda40#.lkml1yggq)
2. [MVP: Part 2](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-2-b2ac6f3f9637#.dge0wl8rl)

#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters.
4. **service**: Services for the application.
5. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
1. RxJava2: https://github.com/amitshekhariitbhu/RxJava2-Android-Samples
2. Dagger2: https://github.com/MindorksOpenSource/android-dagger2-example
3. FastAndroidNetworking: https://github.com/amitshekhariitbhu/Fast-Android-Networking
4. PlaceHolderView: https://github.com/janishar/PlaceHolderView
5. AndroidDebugDatabase: https://github.com/amitshekhariitbhu/Android-Debug-Database
6. Calligraphy: https://github.com/chrisjenx/Calligraphy
7. GreenDao: http://greenrobot.org/greendao/
8. ButterKnife: http://jakewharton.github.io/butterknife/

### Concept reference resources:
1. [Introduction to Dagger 2: Part 1](https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-1-223289c2a01b#.ki6nt86l6)
2. [Introduction to Dagger 2: Part 2](https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-2-b55857911bcd#.mkpzyk8sa)
3. [Android Dagger2: Critical things to know before you implement](https://blog.mindorks.com/android-dagger2-critical-things-to-know-before-you-implement-275663aecc3e#.bskiz1879)
4. [The Best Android Networking Library for Fast and Easy Networking](https://blog.mindorks.com/simple-and-fast-android-networking-19ed860d1455#.cyzrve85o)
5. [RxJava + Fast Android Networking](https://blog.mindorks.com/rxjava-fast-android-networking-6e3d90ee4387#.7hjoex22m)
6. [Migrating from RxJava 1.0 to RxJava 2.0 and Learn RxJava by Examples](https://blog.mindorks.com/migrating-from-rxjava1-to-rxjava2-5dac0a94b4aa#.3lg46kora)
7. [Android Tinder Swipe View Example](https://blog.mindorks.com/android-tinder-swipe-view-example-3eca9b0d4794#.u7i7jbbvy)
8. [Debugging Android Databases And Shared Preferences In The Easiest Way](https://blog.mindorks.com/debugging-android-databases-and-shared-preferences-in-the-easiest-way-e5f705dfc06b#.pxw0hvnws)

###[Check out Mindorks awesome open source projects here](https://mindorks.com/open-source-projects)

### License
```
   Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

### Contributing to Android MVP Architecture
Just make pull request. You are in!
