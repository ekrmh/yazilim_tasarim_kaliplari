package com.ekrmh.yazilimtasarimkaliplari.memento

data class Ayarlar(
    var kullaniciAdi: String? = null,
    var sifre: String? = null,
    var guvenlikKodu: Int? = null
) {


    fun yedekle(): AyarlarMemento {
        val ayarlarMemento = AyarlarMemento()
        ayarlarMemento.kullaniciAdi = this.kullaniciAdi
        ayarlarMemento.sifre = this.sifre
        ayarlarMemento.guvenlikKodu = this.guvenlikKodu
        return ayarlarMemento
    }

    fun yedeklenenAyarlar(ayarlarMemento: AyarlarMemento) {
        this.kullaniciAdi = ayarlarMemento.kullaniciAdi
        this.sifre = ayarlarMemento.sifre
        this.guvenlikKodu = ayarlarMemento.guvenlikKodu
    }
}