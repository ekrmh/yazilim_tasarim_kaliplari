package com.ekrmh.yazilimtasarimkaliplari.prototype

class Prototype(val userUIDList:MutableList<String>) : IPrototype {
    /*
        DeepCopy değer düzeyinde kopyalama sağlar. Nesnede bir değişken değeri değiştiğinde
        diğer nesnedede değişmez. Artık bu nesneler birbirinden bağımsız hale gelmiştir. Ram'de farklı
        referanslarda bulunurlar.
     */
    override fun deepCopy(): IPrototype {
        val copyUserUIDList = mutableListOf<String>()
        copyUserUIDList.addAll(userUIDList)
        return Prototype(copyUserUIDList)

    }

    /*
        ShallowCopy referans düzeyinde kopyalama sağlar. Nesnede bir değişken değeri değiştiğinde
        diğer nesnedede değişir.
     */
    override fun shallowCopy(): IPrototype {
        return this
    }
}