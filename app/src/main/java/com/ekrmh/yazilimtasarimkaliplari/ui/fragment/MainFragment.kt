package com.ekrmh.yazilimtasarimkaliplari.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ekrmh.yazilimtasarimkaliplari.R
import com.ekrmh.yazilimtasarimkaliplari.`object`.pool.ObjectPoolManager
import com.ekrmh.yazilimtasarimkaliplari.abstract_factory.Deneme
import com.ekrmh.yazilimtasarimkaliplari.abstract_factory.KitapFabrikasi
import com.ekrmh.yazilimtasarimkaliplari.abstract_factory.KitapTuru
import com.ekrmh.yazilimtasarimkaliplari.abstract_factory.Roman
import com.ekrmh.yazilimtasarimkaliplari.builder.Ev
import com.ekrmh.yazilimtasarimkaliplari.command.SiparisCikarCommand
import com.ekrmh.yazilimtasarimkaliplari.command.SiparisEkleCommand
import com.ekrmh.yazilimtasarimkaliplari.command.SiparisYonetici
import com.ekrmh.yazilimtasarimkaliplari.factory.UserFactory
import com.ekrmh.yazilimtasarimkaliplari.factory.UserType
import com.ekrmh.yazilimtasarimkaliplari.iterator.Shop
import com.ekrmh.yazilimtasarimkaliplari.memento.Ayarlar
import com.ekrmh.yazilimtasarimkaliplari.memento.AyarlarMemory
import com.ekrmh.yazilimtasarimkaliplari.observable.Email
import com.ekrmh.yazilimtasarimkaliplari.observable.Gozlemci
import com.ekrmh.yazilimtasarimkaliplari.prototype.Prototype
import com.ekrmh.yazilimtasarimkaliplari.singleton.User
import com.ekrmh.yazilimtasarimkaliplari.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.IllegalArgumentException


class MainFragment : BaseFragment() {

    val TAG = MainFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonGoToProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_profileFragment, null))


        // Singleton Pattern
        User.setUserId(context!!)


        // Factory Pattern
        val googleUser = UserFactory.createUser(UserType.google)
        Log.d(TAG,"User Type : " +  googleUser?.getType())


        val facebookUser = UserFactory.createUser(UserType.facebook)
        Log.d(TAG,"User Type : " +  facebookUser?.getType())

        val standartUser = UserFactory.createUser(UserType.standart)
        Log.d(TAG,"User Type : " +  standartUser?.getType())


        // Prototype Pattern

        val userUIDList = mutableListOf("UID1","UID2","UID3","UID4","UID5")
        val basePrototype = Prototype(userUIDList)
        val shallowCopyPrototype = basePrototype.shallowCopy() as Prototype
        val deepCopyPrototype = basePrototype.deepCopy() as Prototype

        basePrototype.userUIDList.add("baseUID1")
        basePrototype.userUIDList.add("baseUID2")

        basePrototype.userUIDList.removeAt(0)

        shallowCopyPrototype.userUIDList.add("shallowUID1")
        shallowCopyPrototype.userUIDList.add("shallowUID2")

        shallowCopyPrototype.userUIDList.removeAt(0)

        deepCopyPrototype.userUIDList.add("deepUID1")
        deepCopyPrototype.userUIDList.add("deepUID2")

        deepCopyPrototype.userUIDList.removeAt(0)

        Log.d(TAG,"Prototype Pattern - BasePrototype userUIDList : ${basePrototype.userUIDList}")
        Log.d(TAG,"Prototype Pattern - ShallowPrototype userUIDList : ${shallowCopyPrototype.userUIDList}")
        Log.d(TAG,"Prototype Pattern - DeepPrototype userUIDList : ${deepCopyPrototype.userUIDList}")

        // Object Pool Pattern
        val user1 = ObjectPoolManager.getNewObject()
        val user2 = ObjectPoolManager.getNewObject()
        val user3 = ObjectPoolManager.getNewObject()
        val user4 = ObjectPoolManager.getNewObject()
        ObjectPoolManager.releaseObject(user1)
        val user5 = ObjectPoolManager.getNewObject()
        ObjectPoolManager.releaseObject(user3)
        val user6 = ObjectPoolManager.getNewObject()
        ObjectPoolManager.releaseObject(user6)
        ObjectPoolManager.releaseObject(user4)
        ObjectPoolManager.releaseObject(user2)
        ObjectPoolManager.releaseObject(user5)





        // Iterator Pattern

        val shop = Shop(listOf("Shop1", "Shop2", "Shop3", "Shop4", "Shop5", "Shop6"))
        val shopIterator = shop.getIterator()

        while (shopIterator.hasNext()){
            val shopName = shopIterator.next()
            Log.d(TAG, "Iterator Pattern -- shopName : $shopName")
        }


        // Memento Pattern
        val ayarlarMemory = AyarlarMemory()

        val ayarlar = Ayarlar()

        ayarlar.kullaniciAdi = "ekremh"
        ayarlar.sifre = "ekrem123"
        ayarlar.guvenlikKodu = 1234

        Log.d(TAG, "Memento Patttern - Ayarlar :  $ayarlar")

        ayarlarMemory.memento = ayarlar.yedekle()

        ayarlar.guvenlikKodu = 4321
        ayarlar.sifre = "ekrem456"

        Log.d(TAG, "Memento Patttern - Güncellenmiş Ayarlar : $ayarlar")

        ayarlar.yedeklenenAyarlar(ayarlarMemory.memento!!)

        Log.d(TAG, "Memento Patttern - Yedeklenen Ayarlar : $ayarlar")


        // Command Pattern

        val siparisYonetici = SiparisYonetici()
        siparisYonetici.komutEkle(SiparisEkleCommand("siparis1",1))
        siparisYonetici.komutEkle(SiparisEkleCommand("siparis2",2))
        siparisYonetici.komutEkle(SiparisEkleCommand("siparis3",3))
        siparisYonetici.komutEkle(SiparisCikarCommand("siparis1",1))
        siparisYonetici.komutEkle(SiparisEkleCommand("siparis4",4))
        siparisYonetici.komutEkle(SiparisEkleCommand("siparis5",5))

        siparisYonetici.komutlarıCalistir()


        // Observable Pattern

        val gozlemci = Gozlemci(Email())
        gozlemci.dogrula(false)
        gozlemci.dogrula(true)


        // Builder Pattern

        val ev = Ev.Builder(3)
            .guvenlik(true)
            .siteIcindeMi(true)
            .ulasimIyiMi(false)
            .build()

        val ev1 = Ev.Builder(2)
            .guvenlik(true)
            .build()

        val ev2 = Ev.Builder(1)
            .guvenlik(false)
            .siteIcindeMi(true)
            .build()
        try {
            val ev3 = Ev.Builder(-1)
                .build()

        } catch (e : IllegalArgumentException){
            Log.d(TAG,e.localizedMessage)
        }

        Log.d(TAG, ev.toString())
        Log.d(TAG, ev1.toString())
        Log.d(TAG, ev2.toString())

        // Abstract Factory

        val roman = KitapFabrikasi.kitapUret("roman1",KitapTuru.ROMAN)
        val deneme = KitapFabrikasi.kitapUret("denemed1",KitapTuru.DENEME)

        roman?.bilgiGetir()
        deneme?.bilgiGetir()


    }


}
