package com.ekrmh.yazilimtasarimkaliplari.abstract_factory

class KitapFabrikasi {
    companion object {
        fun kitapUret(kitapAdi: String, kitapTuru: KitapTuru): Kitap? {
            when (kitapTuru) {
                KitapTuru.ROMAN -> return Roman(kitapAdi, kitapTuru)
                KitapTuru.DENEME -> return Deneme(kitapAdi, kitapTuru)
                else -> return null
            }

        }

    }
}
