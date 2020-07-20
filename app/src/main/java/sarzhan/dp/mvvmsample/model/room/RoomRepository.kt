package sarzhan.dp.mvvmsample.model.room

import androidx.lifecycle.LiveData

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

import sarzhan.dp.mvvmsample.app.CreaturemonApplication
import sarzhan.dp.mvvmsample.model.Creature
import sarzhan.dp.mvvmsample.model.CreatureRepository

class RoomRepository : CreatureRepository {
    private val creatureDao:CreatureDao = CreaturemonApplication.database.creatureDao()
    private val allCreatures: LiveData<List<Creature>>

    init {
        allCreatures = creatureDao.getAllCreatures()
    }

    override fun saveCreature(creature: Creature) {
      Completable.fromAction { creatureDao.insert(creature) }
          .subscribeOn(Schedulers.io())
          .subscribe()

    }

    override fun getAllCreatures() = allCreatures

    override fun clearAllCreatures() {
        val creatureArray = allCreatures.value?.toTypedArray()
        if (creatureArray!=null){
            Completable.fromAction { creatureDao.clearCreatures(*creatureArray) }
                .subscribeOn(Schedulers.io())
                .subscribe()
        }
    }
}