package cl.desafiolatam.superheroes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.InvalidationTracker
import cl.desafiolatam.superheroes.R
import cl.desafiolatam.superheroes.model.api.HeroeListMini
import cl.desafiolatam.superheroes.viewmodel.HeroeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var heroList = ArrayList<HeroeListMini>()
    private lateinit var adapter: AdapterHeroe
    private lateinit var heroViewModel: HeroeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.d("tag", "creando")

        adapter = AdapterHeroe(heroList)
        heroeRecycler.adapter = adapter
        heroViewModel = ViewModelProvider(this).get(HeroeViewModel::class.java)


        heroViewModel.listHero.observe(this, Observer {
            adapter.updateItems(it)
        })
    }
}
