package com.example.quicknote.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.quicknote.Model.Notes

/**
 * 数据库不允许出现重读数据, 如果插入数据库时这个数据已经存在就会造成冲突
 * 以下注解的括号内有几个解决冲突的方式
 * OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务
 * OnConflictStrategy.ROLLBACK：冲突策略是回滚事务
 * OnConflictStrategy.ABORT：冲突策略是终止事务
 * OnConflictStrategy.FAIL：冲突策略是事务失败
 * OnConflictStrategy.IGNORE：冲突策略是忽略冲突
 * */
// 只有Notes为实体类能直接作为参数传递, 否则以其它参数操作的, 都需要使用使用sql语言自定义逻辑
@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: Notes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNotes(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Notes>>

    @Delete
    suspend fun deleteNotes(notes: Notes)
}