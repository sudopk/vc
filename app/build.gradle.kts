import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}


android {
    compileSdkVersion("android-P")
    defaultConfig {
        applicationId = "com.sudopk.vc"
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode = 2
        versionName = "1.1"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

androidExtensions {
    //    https://github.com/gradle/kotlin-dsl/issues/644
//    isExperimental = true
    configure(delegateClosureOf<AndroidExtensionsExtension> {
        isExperimental = true
    })
}

dependencies {
    val kotlin = "1.3-M1"
    val supportLib = "28.0.0"
    val anko = "0.10.3"

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("com.android.support:multidex:1.0.3")

    implementation("android.arch.lifecycle:runtime:1.1.1")
    implementation("android.arch.lifecycle:extensions:1.1.1")
    annotationProcessor("android.arch.lifecycle:compiler:1.1.1")

    implementation("com.android.support:appcompat-v7:${supportLib}")
    implementation("com.android.support:support-v4:${supportLib}")
    implementation("com.android.support:cardview-v7:${supportLib}")
    implementation("com.android.support:recyclerview-v7:${supportLib}")
    implementation("com.android.support:design:${supportLib}")
//    implementation("com.android.support:gridlayout-v7:${supportLib}")

    implementation("com.android.support.constraint:constraint-layout:1.1.3")

//    implementation("com.google.android.gms:play-services:9.2.0")

    //testCompile 'org.mockito:mockito-core:1.10.19'
    //compile 'io.reactivex.rxjava2:rxjava:2.0.0-RC2'
    //compile 'io.reactivex.rxjava2:rxandroid:2.0.0-RC1'

    implementation("com.squareup.retrofit2:retrofit:2.1.0")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")

    implementation("com.google.code.gson:gson:2.8.2")

    implementation("org.jsoup:jsoup:1.9.2")

    implementation("com.sudopk:KAndroidCommon:1.0.5@aar")
    implementation("com.mcxiaoke.koi:core:0.5.5@aar")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlin}")
    implementation("org.jetbrains.anko:anko-common:${anko}")

    //testCompile "org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version"
    //testCompile "org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version"

    testImplementation("junit:junit:4.12")

    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
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