package cl.desafiolatam.superheroes.model.api

import android.content.Context
import android.util.Log
import cl.desafiolatam.superheroes.model.db.DataBaseHeroe
import cl.desafiolatam.superheroes.model.db.EntityHeroe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (context: Context) {

    var dataBaseHeroe = DataBaseHeroe.getDatabase(context)
    var listHeroe = dataBaseHeroe.getDaoHeroe().getMiniHeroe()

    fun loadApiHeroe(){

        val call = RetrofitClient.retrofitIntance().getAllHeroe()
        call.enqueue(object : Callback<List<Heroe>> {
            override fun onFailure(call: Call<List<Heroe>>, t: Throwable) {
                Log.d("Adapter", "Error al cargar heroes")
            }

            override fun onResponse(call: Call<List<Heroe>>, response: Response<List<Heroe>>) {
                Log.d("Adapter", "${response.code()}")
                Log.d("Adapter", "${response.body()}")
                saveDatabase(heroConverter(response.body()!!))
            }
        })
    }

    fun heroConverter(listHero : List<Heroe>) : List<EntityHeroe> {
        return listHero.map { hero -> EntityHeroe(hero.id, hero.name, hero.powerstats, hero.slug, hero.images) }
    }

    fun saveDatabase (listHeroEntity: List<EntityHeroe>) {
        CoroutineScope(Dispatchers.IO).launch {
            dataBaseHeroe.getDaoHeroe().insertHeroes(listHeroEntity)
        }
    }

}