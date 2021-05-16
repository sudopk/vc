package com.sudopk.vc.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.gson.RemoveFieldNameStrategy
import com.sudopk.vc.retrofit.VcService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VcModule {

  @Provides
  @Singleton
  fun provideStrFromRes(@ApplicationContext appContext: Context) = object : StrFromRes {
    override fun getString(resId: Int): String = appContext.getString(resId)

    override fun getString(resId: Int, vararg formatArgs: Any): String {
      return appContext.getString(resId, formatArgs)
    }
  }

  @Singleton
  @Provides
  fun provideGson(): Gson = GsonBuilder()
    .setFieldNamingStrategy(RemoveFieldNameStrategy())
    .create()

  @Singleton
  @Provides
  fun provideVcService(strFromRes: StrFromRes): VcService = VcService.newInstance(strFromRes)
}
