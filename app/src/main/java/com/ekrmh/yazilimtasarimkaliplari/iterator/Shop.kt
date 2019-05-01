package com.ekrmh.yazilimtasarimkaliplari.iterator

class Shop(val shopName:List<String>) : IContainer {


    override fun getIterator() = ShopIterator()



    inner class ShopIterator : IIterator{
        private var index = 0

        override fun hasNext() = index < shopName.size

        override fun next() = if(this.hasNext()) shopName[index++] else null

    }
}