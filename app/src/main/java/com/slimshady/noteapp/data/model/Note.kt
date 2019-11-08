package com.slimshady.noteapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int? = 0,

    @ColumnInfo
    var title: String? = "",

    @ColumnInfo
    var description: String? = ""


)
