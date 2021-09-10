package com.java.data.di

import com.java.data.HomeRepository
import com.java.data.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun bindsHomeRepository(repository: HomeRepositoryImpl): HomeRepository
}
