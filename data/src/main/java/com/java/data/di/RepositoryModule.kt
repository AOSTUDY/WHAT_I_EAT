package com.java.data.di

import com.java.data.HomeRepository
import com.java.data.datasource.HomeDataSource
import com.java.data.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepository(datasource: HomeDataSource): HomeRepository =
        HomeRepositoryImpl(datasource)
}
