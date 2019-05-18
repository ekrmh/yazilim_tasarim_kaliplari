package com.ekrmh.yazilimtasarimkaliplari.observable

import android.util.Log

class Email:IDogrulama {
    val TAG = Email::class.java.simpleName
    override fun onDegerGuncellendi(deger: Boolean) {
        Log.d(TAG,"Observable Pattern -- ${if (deger) "Email Doğrulandı..." else "Doğrulama başarısız..."}")
    }
}