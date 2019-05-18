package com.ekrmh.yazilimtasarimkaliplari.observer

class Gozlemci(val listener:IDogrulama) {

    fun dogrula(deger:Boolean){
        listener.onDegerGuncellendi(deger)
    }

}