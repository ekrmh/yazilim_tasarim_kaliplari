package com.ekrmh.yazilimtasarimkaliplari.factory


class StandartUser: IUser {
    override fun getType(): String {
        return "I am StandartUser"
    }
}