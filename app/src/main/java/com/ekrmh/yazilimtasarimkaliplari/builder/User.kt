package com.ekrmh.yazilimtasarimkaliplari.builder

class User(
    val identityNumber: String?,
    val name: String?,
    val age: Int?) {

    data class Builder(
        var identityNumber: String? = null,
        var name: String? = null,
        var age: Int? = null
    ) {

        fun identityNumber(identityNumber: String) = apply {
            this.identityNumber = identityNumber
            fun name(name: String) = apply { this.name = name }
            fun age(age: Int) = apply { this.age = age }
            fun build() = User(identityNumber, name, age)
        }
    }
}

