package com.java.data.repository

import com.java.data.HomeRepository
import com.java.data.datasource.HomeDataSource
import com.java.data.model.LocalButtonData
import com.java.data.model.TripData
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(private val datasource: HomeDataSource) :
    HomeRepository {
    override fun getNewAndHotData(): List<LocalButtonData> = datasource.getNewAndHotData()

    override fun getBenefitData(): List<LocalButtonData> = datasource.getBenefitData()

    override fun getGoTripData(): List<TripData> = datasource.getGoTripData()
}
