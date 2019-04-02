package com.ekrmh.yazilimtasarimkaliplari.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ekrmh.yazilimtasarimkaliplari.R
import com.ekrmh.yazilimtasarimkaliplari.ui.base.BaseFragment


class MainFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }



}
