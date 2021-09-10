package com.java.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.java.data.HomeRepository
import com.java.data.model.LocalButtonData
import com.java.data.model.TripData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
    private val _newAndHot = MutableLiveData<List<LocalButtonData>>()
    val newAndHot: LiveData<List<LocalButtonData>>
        get() = _newAndHot
    private val _benefit = MutableLiveData<List<LocalButtonData>>()
    val benefit: LiveData<List<LocalButtonData>>
        get() = _benefit
    private val _trip = MutableLiveData<List<TripData>>()
    val trip: LiveData<List<TripData>>
        get() = _trip

    fun getNewAndHot() = viewModelScope.launch {
        runCatching { homeRepository.getNewAndHotData() }
            .onSuccess {
                _newAndHot.postValue(it)
            }
            .onFailure {
                it.printStackTrace()
            }
    }

    fun getBenefit() = viewModelScope.launch {
        runCatching { homeRepository.getBenefitData() }
            .onSuccess {
                _benefit.postValue(it)
            }
            .onFailure {
                it.printStackTrace()
            }
    }

    fun getTrip() = viewModelScope.launch {
        runCatching { homeRepository.getGoTripData() }
            .onSuccess {
                _trip.postValue(it)
            }
            .onFailure {
                it.printStackTrace()
            }
    }
}
