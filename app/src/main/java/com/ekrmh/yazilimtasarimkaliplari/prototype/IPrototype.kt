package com.ekrmh.yazilimtasarimkaliplari.prototype

/*
    Prototype Pattern uygulanacak sınıflar bu interface'yi implement'e etmek zorundadır.
 */
interface IPrototype {
    fun shallowCopy():IPrototype
    fun deepCopy():IPrototype
}