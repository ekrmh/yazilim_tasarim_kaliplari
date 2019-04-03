package com.ekrmh.yazilimtasarimkaliplari.factory

// Factory Pattern

/*

    İstenilen sınıfı oluşturur ve geriye döndürür.
    Standart,Google,Facebook sınıflarından direk nesne türetmek yerine createUser fonksiyonunu kullanarak
    istenilen sınıftan nesne döndürülür.


 */
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