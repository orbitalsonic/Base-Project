package com.orbitalsonic.baseproject.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.postEvent
import com.orbitalsonic.baseproject.R
import com.orbitalsonic.baseproject.databinding.FragmentHomeBinding
import com.orbitalsonic.baseproject.ui.fragments.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_home)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true

            "home_screen".postEvent()
        }
    }

}