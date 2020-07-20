package sarzhan.dp.mvvmsample.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sarzhan.dp.mvvmsample.model.Creature


@Database(entities = [(Creature::class)], version = 1)
@TypeConverters(CreatureAttributesConverter::class)
abstract class CreatureDatabase : RoomDatabase() {
    abstract fun creatureDao():CreatureDao
}