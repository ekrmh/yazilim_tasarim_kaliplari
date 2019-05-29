package com.ekrmh.yazilimtasarimkaliplari.decorator

class SunroofDecorator: Decorator {
    constructor(baseAraba:Araba) : super(baseAraba) {
        this.marka = "Sunroof dahil ${baseAraba.marka}"
        this.fiyat = baseAraba.fiyat + 25000

    }
}