package cl.desafiolatam.superheroes.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://akabab.github.io/"

class RetrofitClient {
    companion object {
        fun retrofitIntance(): ApiHeroe {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiHeroe::class.java)
        }
    }
}
