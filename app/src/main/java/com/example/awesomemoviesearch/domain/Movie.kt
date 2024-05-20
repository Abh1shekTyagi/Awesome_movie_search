package com.example.awesomemoviesearch.domain

data class Movie( val id: Long,
                  val moveName: String,
                  val director: String,
                  val actors: String,
                  val released: String,
                  val rated: String,
                  val genre: String,
                  val rating: String,
                  val plot: String,
                  val imageURL: String)