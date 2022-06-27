package com.diegoalvis.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.diegoalvis.data.db.models.MarkerModel

@Dao
internal interface MarkerDao {

    @Insert(onConflict = IGNORE)
    fun insertMarker(marker: MarkerModel)


    @Query("SELECT * FROM MarkerModel")
    fun getMarkers(): List<MarkerModel>
}
