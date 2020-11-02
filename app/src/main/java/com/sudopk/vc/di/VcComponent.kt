package com.sudopk.vc.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.app.VcApp
import com.sudopk.vc.gson.RemoveFieldNameStrategy
import com.sudopk.vc.retrofit.VcService
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton


@Singleton
@Component(modules = [VcModule::class])
interface VcComponent {
  fun inject(vcApp: VcApp)
}

@Module
class VcModule(private val vcApp: VcApp) {

  @Provides
  @AppContext
  fun provideAppContext(vcApp: VcApp): Context = vcApp

  @Provides
  fun provideApp(): VcApp = vcApp

  @Provides
  fun provideStrFromRes(vcApp: VcApp): StrFromRes = vcApp


  @Singleton
  @Provides
  fun provideGson(): Gson = GsonBuilder()
    .setFieldNamingStrategy(RemoveFieldNameStrategy())
    .create()

  @Singleton
  @Provides
  fun provideVcService(strFromRes: StrFromRes): VcService = VcService.newInstance(strFromRes)
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppContext
