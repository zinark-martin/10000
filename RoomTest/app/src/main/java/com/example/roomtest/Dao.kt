package com.example.roomtest

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyUserDao {
    @Insert
    fun insertUser(user: User): Long //插入完成返回主键值

    @Update
    fun updateUser(newUser: User): Boolean

    @Delete
    fun deleteUser(user: User)

    @Query("select * from User")
    fun loadAllUsers(): LiveData<List<User>>

    @Query("select * from User where age > :age")
    fun loadUserOlderThanAge(age: Int): LiveData<List<User>>

    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName (lastName:String) : Int

}
