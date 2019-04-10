package com.ekrmh.yazilimtasarimkaliplari.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ekrmh.yazilimtasarimkaliplari.R
import com.ekrmh.yazilimtasarimkaliplari.factory.UserFactory
import com.ekrmh.yazilimtasarimkaliplari.factory.UserType
import com.ekrmh.yazilimtasarimkaliplari.prototype.Prototype
import com.ekrmh.yazilimtasarimkaliplari.singleton.User
import com.ekrmh.yazilimtasarimkaliplari.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*


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




    }


}
