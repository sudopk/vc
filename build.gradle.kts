// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0-alpha13")
        val kotlinVersion = "1.3-M1"
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
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

