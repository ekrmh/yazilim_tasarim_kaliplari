package com.ekrmh.yazilimtasarimkaliplari.decorator

abstract class Decorator(val baseAraba:Araba) : Araba(){
    override var marka: String = "Tanımsız Araba"
    override var fiyat: Int = 0
}