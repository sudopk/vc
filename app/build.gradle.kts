plugins {
  id("com.android.application")
  id("dagger.hilt.android.plugin")
  id("kotlin-android")
  id("kotlin-kapt")
}

val composeVersion = "1.3.0-beta02"

android {
  namespace = "com.sudopk.vc"

  compileSdk = 33
  buildToolsVersion = "33.0.0"

  defaultConfig {
    applicationId = "com.sudopk.vc"
    minSdk = 21
    targetSdk = compileSdk
    versionCode = 4
    versionName = "2.1"
    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    multiDexEnabled = true
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    viewBinding = true
    // Enables Jetpack Compose for this module
    compose = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    jvmTarget = "11"
  }

  composeOptions {
    kotlinCompilerExtensionVersion = "1.3.1"
  }

  testOptions {
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  val kotlinVersion = rootProject.extra["kotlinVersion"] as String

  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation("com.android.support:multidex:1.0.3")

  implementation("android.arch.lifecycle:runtime:1.1.1")
  implementation("android.arch.lifecycle:extensions:1.1.1")
//    annotationProcessor("android.arch.lifecycle:compiler:1.1.1")
  implementation("android.arch.lifecycle:common-java8:1.1.1")


  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.activity:activity-ktx:1.5.1")
  implementation("androidx.fragment:fragment-ktx:1.5.2")
  implementation("androidx.preference:preference-ktx:1.2.0")

  implementation("androidx.appcompat:appcompat:1.6.0-rc01")
  implementation("com.google.android.material:material:1.8.0-alpha01")

  implementation("androidx.compose.ui:ui:$composeVersion")
  // Tooling support (Previews, etc.)
  implementation("androidx.compose.ui:ui-tooling:$composeVersion")
  // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
  implementation("androidx.compose.foundation:foundation:$composeVersion")
  // Material Design
  implementation("androidx.compose.material:material:$composeVersion")
  // Material design icons
  implementation("androidx.compose.material:material-icons-core:$composeVersion")
  implementation("androidx.compose.material:material-icons-extended:$composeVersion")
  // Integration with activities
  implementation("androidx.activity:activity-compose:1.5.1")
  // Integration with ViewModels
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha02")
  // Integration with observables
  implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
  implementation("androidx.compose.runtime:runtime-rxjava2:$composeVersion")
  // UI Tests
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

  implementation("com.google.accompanist:accompanist-pager:0.18.0")
  implementation("com.google.accompanist:accompanist-pager-indicators:0.18.0")

  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")

  implementation("com.google.code.gson:gson:2.9.1")

  implementation("org.jsoup:jsoup:1.15.3")

  implementation("com.github.sudopk:KAndroid:1.1.2")

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

//  val daggerVersion = "2.28.3"
//  implementation("com.google.dagger:dagger:$daggerVersion")
//  kapt("com.google.dagger:dagger-compiler:$daggerVersion")
  val hiltVersion = "2.43.2"
  implementation("com.google.dagger:hilt-android:$hiltVersion")
  kapt("com.google.dagger:hilt-android-compiler:2.43.2")

  //testCompile "org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version"
  //testCompile "org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version"

  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.3")

//    androidTestImplementation("com.android.support.test:runner:1.0.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
//    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.2.0")

  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}


// Following is required for running unit tests written in Kotlin
//afterEvaluate {
//    copyKotlinReleaseUnitTestClasses.dependsOn compileReleaseUnitTestJavaWithJavac
//    copyKotlinDebugUnitTestClasses.dependsOn compileDebugUnitTestJavaWithJavac
//    testReleaseUnitTest.dependsOn copyKotlinReleaseUnitTestClasses
//    testDebugUnitTest.dependsOn copyKotlinDebugUnitTestClasses
//}

//task copyKotlinReleaseUnitTestClasses(type: Copy) {
//    from "build/tmp/kotlin-classes/releaseUnitTest"
//    into "build/intermediates/classes/test/release"
//}
//
//task copyKotlinDebugUnitTestClasses(type: Copy) {
//    from "build/tmp/kotlin-classes/debugUnitTest"
//    into "build/intermediates/classes/test/debug"
//}