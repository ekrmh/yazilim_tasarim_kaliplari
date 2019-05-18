package com.ekrmh.yazilimtasarimkaliplari.observer

import android.util.Log

class Email:IDogrulama {
    val TAG = Email::class.java.simpleName
    override fun onDegerGuncellendi(deger: Boolean) {
        Log.d(TAG,"observer Pattern -- ${if (deger) "Email Doğrulandı..." else "Doğrulama başarısız..."}")
    }
}