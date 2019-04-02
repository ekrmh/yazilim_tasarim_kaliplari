package com.ekrmh.yazilimtasarimkaliplari.model

import android.content.Context
import com.ekrmh.yazilimtasarimkaliplari.application.ApplicationKey
import com.ekrmh.yazilimtasarimkaliplari.application.DiskDataHandler
import java.util.*

object User {
    lateinit var userId:String

    fun setUserId(context: Context): String {
        if (DiskDataHandler.getFromDisk(context,ApplicationKey.USER_ID,String::class.java) != null){
            val userId = DiskDataHandler.getFromDisk(context,ApplicationKey.USER_ID,String::class.java) as String
            this.userId = userId
            return userId
        }
        else {
            val userId = UUID.randomUUID().toString()
            DiskDataHandler.writeToDisk<String>(context,ApplicationKey.USER_ID, userId)
            this.userId = userId
            return UUID.randomUUID().toString()

        }
    }

}