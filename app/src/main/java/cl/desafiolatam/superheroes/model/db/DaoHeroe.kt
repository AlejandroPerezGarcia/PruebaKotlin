package cl.desafiolatam.superheroes.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.superheroes.model.api.HeroeListMini

@Dao
interface DaoHeroe {

    @Query("select * from heroe_table")
    fun getAllheroe() : LiveData<List<EntityHeroe>>

    @Query("select id,name,images_md from heroe_table")
    fun getMiniHeroe() :LiveData<List<HeroeListMini>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroeList: List<EntityHeroe>)

}