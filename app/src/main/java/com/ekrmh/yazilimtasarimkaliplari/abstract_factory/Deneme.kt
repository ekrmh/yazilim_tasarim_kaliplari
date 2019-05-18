package com.ekrmh.yazilimtasarimkaliplari.abstract_factory

import android.util.Log

class Deneme(val kitapAdi:String, val kitapTuru:KitapTuru): Kitap(kitapAdi,kitapTuru){
    val TAG = Roman::class.java.simpleName
    override fun bilgiGetir() {
        Log.d(TAG,"Abstract Factory -- Deneme -- Kitap Adi : $kitapAdi, Kitap Türü : $kitapTuru")
    }

}