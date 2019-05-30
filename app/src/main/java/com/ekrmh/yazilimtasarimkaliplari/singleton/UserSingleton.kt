package com.ekrmh.yazilimtasarimkaliplari.singleton


class UserSingleton private constructor(){
    var isim = ""
    var yas = 0
    companion object {
        var userSingleton: UserSingleton?=null

        fun getInstance():UserSingleton{
            if (userSingleton == null)
                userSingleton = UserSingleton()
            return userSingleton as UserSingleton
        }
    }
}