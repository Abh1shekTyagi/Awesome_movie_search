package com.example.awesomemoviesearch.repo

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.map
import com.example.awesomemoviesearch.database.MovieDAO
import com.example.awesomemoviesearch.database.MovieDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale

class MovieRepository(private val database: MovieDatabase, private val context: Context) {


    suspend fun getMovies(name: String) {
        withContext(Dispatchers.IO) {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetwork

            if (networkInfo != null) {
                val moviesList = Network.asteroid.getAsteroidList()
                database.asteroidDao.insertAll(*asteroidList.asDatabaseModel())
                database.asteroidDao.deletePassedAsteroids(dateFormat.format(currentTime))
            }
        }
    }


    suspend fun getWeekAsteroids(): List<Asteroid> {
        val startDate = dateFormat.format(currentTime)
        val calendarInstance = calendar
        calendarInstance.add(Calendar.DAY_OF_MONTH, DEFAULT_END_DATE_DAYS)
        val endDate = dateFormat.format(calendarInstance.time)
        return database.asteroidDao.getWeekAsteroids(startDate, endDate).asDomainModel()
    }
}