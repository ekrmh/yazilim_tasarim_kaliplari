package com.ekrmh.yazilimtasarimkaliplari.application

import android.content.Context
import com.google.gson.Gson
import kotlin.reflect.KClass
import com.google.gson.GsonBuilder
import java.lang.reflect.Modifier.TRANSIENT

// Singleton object
object DiskDataHandler {
    val PREFS_FILENAME = "TasarimKaliplari"
    fun <T: Any>  writeToDisk(context: Context, key:ApplicationKey, o:Any){
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

