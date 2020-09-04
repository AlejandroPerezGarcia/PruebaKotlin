package cl.desafiolatam.superheroes.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.desafiolatam.superheroes.model.api.Images
import cl.desafiolatam.superheroes.model.api.Powerstats


@Entity (tableName = "heroe_table")
data class EntityHeroe (

    @PrimaryKey val id : Int,
    val name : String,
    @Embedded (prefix = "ps_") val powerstats: Powerstats,
    val slug : String,
    @Embedded(prefix = "images_") val images: Images

)
