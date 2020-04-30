package com.example.viewmodeltest

import androidx.room.*

@Dao//必须加注解Room才会将这个接口识别为一个Dao
interface UserDao {
    //下面是常用的增删改查

    //返回主键id值
    @Insert
    fun insertUser(user: User): Long

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User")//这里面的东西不分大小写...
    fun loadAllUser(): List<User>

    @Query("select * from User where age > :age")
    fun loadUserOlderThan(age: Int): List<Int>

    //参数只要是非实体类, 比如下面的String, 那么只有使用@Query(SQL语言)一种选择
    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName(lastName: String): Int

    @Delete
    fun deleteUser(user: User)
}