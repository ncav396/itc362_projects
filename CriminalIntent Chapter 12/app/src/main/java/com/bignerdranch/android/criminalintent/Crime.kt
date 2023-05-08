package com.bignerdranch.android.criminalintent
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
// Importing to fix UUID red squiggle resulted in the * inclusion of all, hopefully this does not adversely affect Date

@Entity
data class Crime(
    @PrimaryKey val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)
