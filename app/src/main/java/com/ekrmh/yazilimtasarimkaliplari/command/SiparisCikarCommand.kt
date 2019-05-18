package com.ekrmh.yazilimtasarimkaliplari.command

import android.util.Log

data class SiparisCikarCommand(val isim:String, val ucret:Int) : ISiparisCommand {
    val TAG = SiparisCikarCommand::class.java.simpleName

    override fun calistir() {
        Log.d(TAG,"Command Pattern -- siparis çıkarıldı : $this")

    }

}