package com.mt.lib_cache.database

import androidx.room.Database
import androidx.room.FtsOptions
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mt.lib_cache.dao.UserDao
import com.mt.lib_cache.model.User
import com.mt.lib_common.util.AppGlobals

/**
 *  @author : MaoTong
 *  @date : 2020/9/16 10:40
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/16 10:40
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
@Database(entities = [User::class], version = 1)
abstract class CacheDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        var database: CacheDataBase? = null
        fun getInstance():CacheDataBase {
            return (database ?: synchronized(this) {
                database ?: buildDatabase().also { database = it }
            }) as CacheDataBase
        }
        fun buildDatabase(): CacheDataBase? {
            return AppGlobals.sApplication?.let {
                Room.databaseBuilder(it, CacheDataBase::class.java, "database_name")
                    // 是否在主线程执行查询操作
                    .allowMainThreadQueries()
                    .build()
            }
        }
    }
}