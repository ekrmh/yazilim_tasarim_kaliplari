package com.ekrmh.yazilimtasarimkaliplari.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ekrmh.yazilimtasarimkaliplari.R
import com.ekrmh.yazilimtasarimkaliplari.model.User
import com.ekrmh.yazilimtasarimkaliplari.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        User.setUserId(context!!)
        buttonGoToProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_profileFragment, null))


    }


}
