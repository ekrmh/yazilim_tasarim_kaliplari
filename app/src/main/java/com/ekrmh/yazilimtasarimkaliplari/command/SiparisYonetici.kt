package com.ekrmh.yazilimtasarimkaliplari.command

class SiparisYonetici {
    private val komutlar = arrayListOf<ISiparisCommand>()

    fun komutEkle(command: ISiparisCommand){
        komutlar.add(command)
    }

    fun komutlarıCalistir(){
        komutlar.forEach {
            it.calistir()
        }
        komutlar.clear()
    }
}