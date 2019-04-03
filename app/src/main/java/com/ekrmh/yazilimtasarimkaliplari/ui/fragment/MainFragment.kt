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


    }


}
