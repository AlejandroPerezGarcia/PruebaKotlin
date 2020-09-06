package cl.desafiolatam.superheroes.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cl.desafiolatam.superheroes.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("tag", "creando")

    }
}
