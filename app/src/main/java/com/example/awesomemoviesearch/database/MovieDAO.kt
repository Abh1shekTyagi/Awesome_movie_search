package com.example.awesomemoviesearch.database

import com.example.awesomemoviesearch.domain.Movie

package com.example.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query

@Dao
interface MovieDAO {
    @Insert(onConflict = IGNORE)
    suspend fun insertAll(vararg asteroids: MovieEntity)

    @Query("Select * from movies_table where moveName = :name") //check for regex
    fun getMovies(name: String): LiveData<List<Movie>>
}