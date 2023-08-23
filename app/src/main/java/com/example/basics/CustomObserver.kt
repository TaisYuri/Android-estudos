package com.example.basics

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class CustomObserver: DefaultLifecycleObserver, LifecycleEventObserver {

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("LifeCycle", "Observer ${owner.toString()} - OnResume")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("LifeCycle", "Observer ${source.toString()} - event: ${event.toString()}")

    }
}