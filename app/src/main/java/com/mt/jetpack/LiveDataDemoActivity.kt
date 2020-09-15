package com.mt.jetpack

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

class LiveDataDemoActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    val liveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 先 observe，后 postValue，可以收到通知
        /*liveData.observe(this, {
            // 回调到主线程
            Log.e(TAG, ": MTMTMT " + it + "  " + Thread.currentThread().name);
        })*/

        // 先 postValue ，后 observe ， 也可以收到通知，由生命周期回调调用
//        liveData.postValue("先 postValue")

        // 可以有多个 observe
        liveData.observe(this, {
            // 回调到主线程
            Log.e(TAG, ": MTMTMT onCreate observe" + it + "  " + Thread.currentThread().name);
        })
    }

    fun sendMessage(view: View) {
//        liveData.value = "setValue 只能在主线程调用"
        Thread{
            liveData.postValue("post value 可以在子线程调用")
        }.start()
    }

    fun sendStickyMessage(view: View) {
        liveData.postValue("sticky")
        liveData.observe(this, {
            // 回调到主线程
            Log.e(TAG, ": MTMTMT sticky " + it + "  " + Thread.currentThread().name);
        })

        lifecycle.addObserver(MyListener())
    }

    class MyListener:LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            Log.e(TAG, ": MTMTMT " + event.name);
        }

    }
}