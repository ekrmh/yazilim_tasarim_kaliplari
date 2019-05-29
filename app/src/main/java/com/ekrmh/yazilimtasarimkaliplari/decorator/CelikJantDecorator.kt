package com.ekrmh.yazilimtasarimkaliplari.decorator

class CelikJantDecorator: Decorator {
    constructor(baseAraba:Araba) : super(baseAraba) {
        this.marka = "Celik Jantlı ${baseAraba.marka}"
        this.fiyat = baseAraba.fiyat + 15000

    }
}