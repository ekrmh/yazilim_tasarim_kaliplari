package com.ekrmh.yazilimtasarimkaliplari.`object`.pool

import android.util.Log

class User(){
    val TAG = User::class.java.simpleName
    init {

        Log.d(TAG,"Object Pool Pattern : created new user...")
    }
}