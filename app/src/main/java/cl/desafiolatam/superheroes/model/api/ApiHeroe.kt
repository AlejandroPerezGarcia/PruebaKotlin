package cl.desafiolatam.superheroes.model.api


import retrofit2.Call
import retrofit2.http.GET

interface ApiHeroe {
    @GET("superhero-api/api/all.json")
    fun getAllHeroe() : Call<List<Heroe>>
}