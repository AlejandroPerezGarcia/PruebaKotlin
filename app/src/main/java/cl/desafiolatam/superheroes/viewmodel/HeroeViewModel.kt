package cl.desafiolatam.superheroes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import cl.desafiolatam.superheroes.model.api.Repository

class HeroeViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: Repository = Repository(application)
    var listHero = repository.listHeroe

    init {
        repository = Repository(application)

        repository.loadApiHeroe()

    }
}