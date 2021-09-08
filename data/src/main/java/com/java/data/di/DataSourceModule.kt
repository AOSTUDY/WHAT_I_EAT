package com.java.data.di

import com.java.data.datasource.HomeDataSource
import com.java.data.datasource.LocalHomeDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideHomeDataSource(): HomeDataSource = LocalHomeDataSource()
}