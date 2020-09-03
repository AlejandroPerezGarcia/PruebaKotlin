package cl.desafiolatam.superheroes.api

data class Heroe(
    val appearance: Appearance,
    val id: Int,
    val images: Images,
    val name: String,
    val powerstats: Powerstats,
    val slug: String

)