package com.ekrmh.yazilimtasarimkaliplari.factory


class UserFactory {
    companion object {
        fun createUser(key:UserType): IUser? {
            when(key){
                UserType.standart -> { return StandartUser()}
                UserType.google -> { return GoogleUser()}
                UserType.facebook -> { return FacebookUser() }
                else -> { return null }

            }
        }
    }
}