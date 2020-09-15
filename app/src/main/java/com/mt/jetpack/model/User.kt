package com.mt.jetpack.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.mt.jetpack.BR

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
class User(s: String, s1: String): BaseObservable() {

    var name: String? = null
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var age: String? = null

    init {
        name = s
        age = s1
    }
}