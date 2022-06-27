package com.diegoalvis.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.diegoalvis.data.db.MarkerDb.Companion.DATABASE_VERSION
import com.diegoalvis.data.db.dao.MarkerDao
import com.diegoalvis.data.db.models.MarkerModel

@Database(
    entities = [
        MarkerModel::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
internal abstract class MarkerDb : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "marker"
    }

    abstract val markerDao: MarkerDao
}



// TODO: Move to utils
inline fun <reified Database : RoomDatabase> getRoomDbInstance(
    context: Context,
    databaseName: String,
): Database =
    Room.databaseBuilder(context.applicationContext, Database::class.java, databaseName)
        .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
        .build()