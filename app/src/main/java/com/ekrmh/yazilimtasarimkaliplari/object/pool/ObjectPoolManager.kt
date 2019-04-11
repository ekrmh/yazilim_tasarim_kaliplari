package com.ekrmh.yazilimtasarimkaliplari.`object`.pool

import android.util.Log
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

object ObjectPoolManager {
    val TAG = ObjectPoolManager::class.java.simpleName
    val size = 3
    val objectList = hashSetOf<User>()
    val lock = ReentrantLock()

    /*
        nesne sayısını belirli bir sınırda tutmak için bu yapı kullanılır.
     */
    fun getNewObject():User? {
        // Multithread yapıda düzenli çalışması için lock yapısı kullanılmıştır.
        lock.withLock {
            return if (objectList.size < size){
                val user = User()
                objectList.add(user)
                user
            } else {
                Log.d(TAG,"Object Pool Pattern : objectList is full, try again later")
                null
            }
        }
    }

    fun releaseObject(user: User?){
        user?.let {
            objectList.remove(user)
            Log.d(TAG,"Object Pool Pattern : user object removed from objectList")
        }
    }
}


