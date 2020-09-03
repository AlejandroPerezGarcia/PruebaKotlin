package cl.desafiolatam.superheroes.api


import retrofit2.Call
import retrofit2.http.GET

interface ApiHeroe {
    @GET("superhero-api/api/all.json")
    fun getAllHeroe() : Call<Heroe>
}