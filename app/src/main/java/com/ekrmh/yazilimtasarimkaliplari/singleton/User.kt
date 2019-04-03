package com.ekrmh.yazilimtasarimkaliplari.singleton

import android.content.Context
import com.ekrmh.yazilimtasarimkaliplari.application.ApplicationKey
import java.util.*


// Singleton object
// Bu sınıfın görevi her kullanıcıya benzersiz bir id tanımlar.
// Uygulama çalıştığında benzersiz bir id oluşturulur ve singleton olduğundan her defasında
// nesne türetmeden bu değere ulaşılabilir.
object User {
    lateinit var userId:String

    fun setUserId(context: Context): String {
        if (DiskDataHandler.getFromDisk(context,ApplicationKey.USER_ID,String::class.java) != null){
            val userId = DiskDataHandler.getFromDisk(context,ApplicationKey.USER_ID,String::class.java) as String
            User.userId = userId
            return userId
        }
        else {
            val userId = UUID.randomUUID().toString()
            DiskDataHandler.writeToDisk<String>(context,ApplicationKey.USER_ID, userId)
            User.userId = userId
            return UUID.randomUUID().toString()

        }
    }

}