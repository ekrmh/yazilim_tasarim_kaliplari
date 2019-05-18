package com.ekrmh.yazilimtasarimkaliplari.builder


class Ev private constructor(builder: Builder) {
    private val siteIcindeMi: Boolean
    private val ulasimIyiMi: Boolean
    private val guvenlik: Boolean
    private val odaSayisi: Int

    override fun toString(): String {
        return " Builder Pattern -- Güvenlik : ${this.guvenlik},Oda Sayisi : ${this.odaSayisi},Ulasim : ${this.ulasimIyiMi},Site : ${this.siteIcindeMi}"
    }

    init {
        siteIcindeMi = builder.siteIcindeMi
        ulasimIyiMi = builder.ulasimIyiMi
        guvenlik = builder.guvenlik
        odaSayisi = builder.odaSayisi
    }

    class Builder(val odaSayisi: Int) {
        var siteIcindeMi: Boolean = false
        var ulasimIyiMi: Boolean = false
        var guvenlik: Boolean = false

        init {
            if (odaSayisi <= 0)
                throw IllegalArgumentException("Builder Pattern -- Oda sayisi 0'dan büyük olmak zorundadır.")
         }

        fun siteIcindeMi(siteIcindeMi: Boolean): Builder {
            this.siteIcindeMi = siteIcindeMi
            return this
        }

        fun guvenlik(guvenlik: Boolean): Builder {
            this.guvenlik = guvenlik
            return this
        }

        fun ulasimIyiMi(ulasimIyiMi: Boolean): Builder {
            this.ulasimIyiMi = ulasimIyiMi
            return this
        }

        fun build(): Ev {
            return Ev(this)
        }

    }
}