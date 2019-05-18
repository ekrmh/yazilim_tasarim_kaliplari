package com.ekrmh.yazilimtasarimkaliplari.abstract_factory

import android.util.Log

class Roman(val kitapAdi:String, val kitapTuru:KitapTuru): Kitap(kitapAdi,kitapTuru){
    val TAG = Roman::class.java.simpleName
    override fun bilgiGetir() {
        Log.d(TAG,"Abstract Factory -- Roman -- Kitap Adi : $kitapAdi, Kitap Türü : $kitapTuru")
    }

}