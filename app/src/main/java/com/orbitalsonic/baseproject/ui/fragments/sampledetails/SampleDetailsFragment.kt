package com.orbitalsonic.baseproject.ui.fragments.sampledetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.postEvent
import com.orbitalsonic.baseproject.R
import com.orbitalsonic.baseproject.databinding.FragmentSampleDetailsBinding
import com.orbitalsonic.baseproject.ui.fragments.BaseFragment

class SampleDetailsFragment : BaseFragment<FragmentSampleDetailsBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_sample_details)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true

            "sample_screen".postEvent()

        }
    }


}