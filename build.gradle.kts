// Top-level build file where you can add configuration options common to all sub-projects/modules.



buildscript {
  rootProject.extra["kotlinVersion"] = "1.4.10"
  val kotlinVersion =  rootProject.extra["kotlinVersion"] as String

  repositories {
    google()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
  }
  dependencies {
    // Android gradle plugin.
    classpath("com.android.tools.build:gradle:4.2.0-alpha15")
    // Kotlin gradle plugin.
    classpath(kotlin("gradle-plugin", version = kotlinVersion))
    classpath(kotlin("android-extensions", version = kotlinVersion))

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts files
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}

