package com.ekrmh.yazilimtasarimkaliplari.command

import android.util.Log

data class SiparisEkleCommand(val isim:String, val ucret:Int) : ISiparisCommand {

    val TAG = SiparisEkleCommand::class.java.simpleName
    override fun calistir() {
        Log.d(TAG,"Command Pattern -- siparis eklendi : $this")
    }

}