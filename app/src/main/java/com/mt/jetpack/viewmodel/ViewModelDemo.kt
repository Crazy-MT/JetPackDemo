package com.mt.jetpack.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mt.jetpack.model.User

/**
 * @author : MaoTong
 * @date : 2020/9/15 14:18
 * description :
 */
/**
 * ================================================
 * @author : MaoTong
 * @date : 2020/9/15 14:18
 * description :
 * [Contact me](mailto:ytumaotong@gmail.com)
 * [Follow me](https://github.com/Crazy-MT)
 * ================================================
 */
class ViewModelDemo : ViewModel() {
    var user: MutableLiveData<User>? = MutableLiveData<User>()
        get() {
            if (field?.value == null) {
                field?.value = User("name", "2")
            }
            return field
        }
        set(value) {
            field = value
        }

/*
    val user: User by lazy {
        User("1", "2")
    }
*/

    companion object {
        private const val TAG = "ActivityViewModel"
    }
}