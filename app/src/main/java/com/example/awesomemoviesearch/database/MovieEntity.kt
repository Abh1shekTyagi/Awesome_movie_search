package com.example.awesomemoviesearch.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.awesomemoviesearch.domain.Movie

@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey
    val id: Long,
    val moveName: String,
    val director: String,
    val actors: String,
    val released: String,
    val rated: String,
    val genre: String,
    val rating: String,
    val plot: String,
    val imageURL: String
)



fun List<MovieEntity>.asDomainModel(): List<Movie> {
    return map {
        Movie(
            id = it.id,
            moveName = it.moveName,
            director = it.director,
            actors = it.actors,
            released = it.released,
            rated = it.rated,
            genre = it.genre,
            rating = it.rating,
            plot = it.plot,
            imageURL = it.imageURL
        )
    }
}
