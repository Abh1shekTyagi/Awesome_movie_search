package com.example.awesomemoviesearch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.awesomemoviesearch.domain.Movie
import kotlinx.coroutines.launch

class MainActivityViewModel (application: Application): AndroidViewModel(application) {

    private val  database = getDatabase(application)
    private val repository = AsteroidRepository(database, context = application.applicationContext)

    private val _movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieList: LiveData<List<Movie>> = _movieList

    init {
        viewModelScope.launch {
            repository.getAsteroids()
            repository.getPictureOfDay()
        }
    }
    val asteroidDataList = repository.asteroids
    val picturesByDay = repository.pictureOfTheDay

    fun getHazardousAsteroids() {
        viewModelScope.launch {
            _filteredAsteroids.postValue(repository.getHazardousAsteroids())
        }
    }

    fun getNotHazardousAsteroids() {
        viewModelScope.launch {
            _filteredAsteroids.postValue(repository.getNotHazardousAsteroids())
        }
    }

    fun getTodayAsteroids() {
        viewModelScope.launch {
            _filteredAsteroids.postValue(repository.getTodayAsteroids())
        }
    }

    fun getAllAsteroids() {
        viewModelScope.launch {
            _filteredAsteroids.postValue(repository.getAllAsteroids())
        }
    }

    fun getWeekAsteroids() {
        viewModelScope.launch {
            _filteredAsteroids.postValue(repository.getWeekAsteroids())
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainActivityViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}

