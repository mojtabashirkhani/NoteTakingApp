package com.slimshady.noteapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable
import java.lang.reflect.Constructor
import java.util.*

@Entity(tableName = "note")
data class Note (


    @PrimaryKey
    @ColumnInfo
    var id: String = UUID.randomUUID().toString(),

    @ColumnInfo
    var title: String? = "",

    @ColumnInfo
    var description: String? = ""



) : Serializable



