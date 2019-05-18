package com.ekrmh.yazilimtasarimkaliplari.observable

class Gozlemci(val listener:IDogrulama) {

    fun dogrula(deger:Boolean){
        listener.onDegerGuncellendi(deger)
    }

}