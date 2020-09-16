package com.mt.lib_cache.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mt.lib_cache.BR

/**
 *  @author : MaoTong
 *  @date : 2020/9/15 13:27
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/15 13:27
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
@Entity(tableName = "tb_user")
class User constructor(): BaseObservable() {
    @PrimaryKey
    var u_id: Int = 0

    constructor(s: String, s1: String) : this() {
        name = s
        age = s1
    }

    var name: String? = null
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var age: String? = null
}