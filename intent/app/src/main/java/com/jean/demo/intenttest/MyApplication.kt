package com.jean.demo.intenttest

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * Created on 2018/4/29.
 */
@Suppress("unused")
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{
            override fun onActivityPaused(p0: Activity?) {
                Log.i("LifeCycle", "onActivityPaused " + p0!!.localClassName)
            }

            override fun onActivityResumed(p0: Activity?) {
                Log.i("LifeCycle", "onActivityResumed " + p0!!.localClassName)
            }

            override fun onActivityStarted(p0: Activity?) {
                Log.i("LifeCycle", "onActivityStarted " + p0!!.localClassName)
            }

            override fun onActivityDestroyed(p0: Activity?) {
                Log.i("LifeCycle", "onActivityDestroyed " + p0!!.localClassName)
            }

            override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
                Log.i("LifeCycle", "onActivitySaveInstanceState " + p0!!.localClassName)
            }

            override fun onActivityStopped(p0: Activity?) {
                Log.i("LifeCycle", "onActivityStopped " + p0!!.localClassName)
            }

            override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
                Log.i("LifeCycle", "onActivityCreated " + p0!!.localClassName)
            }
        })
    }
}