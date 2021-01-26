plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
}

android {
  compileSdkVersion(30)
  buildToolsVersion = "30.0.2"

  defaultConfig {
    applicationId = "com.sudopk.vc"
    minSdkVersion(16)
    targetSdkVersion(30)
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
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  testOptions {
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  val kotlinVersion = rootProject.extra["kotlinVersion"] as String
  val ankoVersion = "0.10.3"

  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation("com.android.support:multidex:1.0.3")

  implementation("android.arch.lifecycle:runtime:1.1.1")
  implementation("android.arch.lifecycle:extensions:1.1.1")
//    annotationProcessor("android.arch.lifecycle:compiler:1.1.1")
  implementation("android.arch.lifecycle:common-java8:1.1.1")


  implementation("androidx.core:core-ktx:1.5.0-beta01")

  implementation("androidx.appcompat:appcompat:1.3.0-beta01")
  implementation("com.google.android.material:material:1.3.0-rc01")
  implementation("androidx.preference:preference-ktx:1.1.1")

  implementation("com.android.support.constraint:constraint-layout:2.0.4")

//    implementation("com.google.android.gms:play-services:9.2.0")

  //testCompile 'org.mockito:mockito-core:1.10.19'
  //compile 'io.reactivex.rxjava2:rxjava:2.0.0-RC2'
  //compile 'io.reactivex.rxjava2:rxandroid:2.0.0-RC1'

  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")

  implementation("com.google.code.gson:gson:2.8.6")

  implementation("org.jsoup:jsoup:1.13.1")

  implementation("com.sudopk:KAndroidCommon:1.0.5@aar")
  implementation("com.mcxiaoke.koi:core:0.5.5@aar")

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0")
  implementation("org.jetbrains.anko:anko-common:$ankoVersion")

  val daggerVersion = "2.28.3"
  implementation("com.google.dagger:dagger:$daggerVersion")
  kapt("com.google.dagger:dagger-compiler:$daggerVersion")

  //testCompile "org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version"
  //testCompile "org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version"

  testImplementation("junit:junit:4.13.1")
  testImplementation("com.google.truth:truth:1.1")

//    androidTestImplementation("com.android.support.test:runner:1.0.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.2")
//    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.2.0")

  androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
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