package com.mt.lib_cache.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mt.lib_cache.model.User

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
    var user: MutableLiveData<com.mt.lib_cache.model.User>? = MutableLiveData<com.mt.lib_cache.model.User>()
        get() {
            if (field?.value == null) {
                field?.value = com.mt.lib_cache.model.User("name", "2")
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