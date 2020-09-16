package com.mt.jetpack

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mt.jetpack.databinding.ActivityViewModelBinding
import com.mt.lib_cache.model.User
import com.mt.lib_cache.viewmodel.ViewModelDemo

/**
 * @author : MaoTong
 * @date : 2020/9/15 14:26
 * description :
 */
/**
 * ================================================
 * @author : MaoTong
 * @date : 2020/9/15 14:26
 * description :
 * [Contact me](mailto:ytumaotong@gmail.com)
 * [Follow me](https://github.com/Crazy-MT)
 * ================================================
 */
class ViewModelActivity : AppCompatActivity() {
    var activityViewModel: ViewModelDemo? = null
    var binding: ActivityViewModelBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityViewModel = ViewModelDemo()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)
        binding?.viewmodel = activityViewModel
        binding?.lifecycleOwner = this

        activityViewModel?.user?.observe(this, Observer {
            Log.e(TAG, ": MTMTMT observe " + it.name);
        })
    }

    companion object {
        private const val TAG = "ViewModelActivity"
    }

    fun setUser(view: View) {
        Log.e(TAG, ": MTMTMT click " + activityViewModel?.user?.value?.name)
        activityViewModel?.user?.postValue(activityViewModel?.user?.value)
    }
}