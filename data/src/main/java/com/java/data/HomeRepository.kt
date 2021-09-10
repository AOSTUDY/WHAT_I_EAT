package com.java.data

import com.java.data.model.LocalButtonData
import com.java.data.model.TripData

interface HomeRepository {
    fun getNewAndHotData(): List<LocalButtonData>

    fun getBenefitData(): List<LocalButtonData>

    fun getGoTripData(): List<TripData>
}
