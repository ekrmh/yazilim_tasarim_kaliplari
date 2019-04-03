package com.ekrmh.yazilimtasarimkaliplari.singleton

import android.content.Context
import com.ekrmh.yazilimtasarimkaliplari.application.ApplicationKey
import com.google.gson.GsonBuilder

// Singleton object
object DiskDataHandler {
    val PREFS_FILENAME = "TasarimKaliplari"
    fun <T: Any>  writeToDisk(context: Context, key: ApplicationKey, o:Any){
        val gson = GsonBuilder().create();

        val json = gson.toJson(o)
        val prefences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val editor = prefences.edit()
        editor.putString(key.name,json)
        editor.apply()
    }

    fun <T: Any> getFromDisk(
        context: Context,
        key: ApplicationKey,
        clazz : Class<T>): Any? {
        val gson =  GsonBuilder()
            .create();
        val prefences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val obj = gson.fromJson(prefences.getString(key.name,null),clazz)
        return obj
    }


}

