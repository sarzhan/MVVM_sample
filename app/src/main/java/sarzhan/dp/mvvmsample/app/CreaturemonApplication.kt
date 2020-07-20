package sarzhan.dp.mvvmsample.app

import android.app.Application
import androidx.room.Room
import sarzhan.dp.mvvmsample.model.room.CreatureDatabase

class CreaturemonApplication:Application() {
    companion object{
        lateinit var database:CreatureDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,CreatureDatabase::class.java, "creature_database")
            .build()
    }
}