package com.mt.lib_cache.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mt.lib_cache.model.User

/**
 *  @author : MaoTong
 *  @date : 2020/9/16 11:18
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/16 11:18
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
@Dao
public interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: User)

    @Query("SELECT * FROM tb_user WHERE u_id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray) : List<User>

    @Query("SELECT * FROM tb_user WHERE u_id = (:userId)")
    fun loadById(userId: Int) : User

    @Query("SELECT * FROM tb_user")
    fun getAll() : LiveData<List<User>>

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}