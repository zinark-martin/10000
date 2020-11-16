package com.example.roomtest

import androidx.lifecycle.LiveData
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var firstName: LiveData<String>,
    var lastName: LiveData<String>,
    var age: LiveData<Int>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}




