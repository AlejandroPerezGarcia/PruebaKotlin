package cl.desafiolatam.superheroes.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EntityHeroe::class],version = 1)
abstract class DataBaseHeroe : RoomDatabase() {

    abstract fun getDaoHeroe() : DaoHeroe

    companion object{

        @Volatile
        private var INSTANCE : DataBaseHeroe? =  null

        fun getDatabase(context: Context) : DataBaseHeroe {
            val tempInstance =
                INSTANCE
            if (tempInstance != null)
            {
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseHeroe::class.java,
                    "heroe_database"
                ).build()
                INSTANCE = instance
                return instance

            }

        }

    }


}