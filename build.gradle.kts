// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {
  rootProject.extra["kotlinVersion"] = "1.4.21"
  val kotlinVersion = rootProject.extra["kotlinVersion"] as String

  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    // Android gradle plugin.
    classpath("com.android.tools.build:gradle:7.0.0-alpha15")
    // Kotlin gradle plugin.
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    classpath("com.google.dagger:hilt-android-gradle-plugin:2.31.2-alpha")

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts files
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
    maven(url ="https://jitpack.io")
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}

