package com.java.data.datasource

import com.java.data.model.LocalButtonData
import com.java.data.model.TripData

interface HomeDataSource {
    fun getNewAndHotData(): List<LocalButtonData>

    fun getBenefitData(): List<LocalButtonData>

    fun getGoTripData(): List<TripData>
}
