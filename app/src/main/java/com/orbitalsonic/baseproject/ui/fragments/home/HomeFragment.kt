package com.orbitalsonic.baseproject.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.postEvent
import com.orbitalsonic.baseproject.R
import com.orbitalsonic.baseproject.databinding.FragmentHomeBinding
import com.orbitalsonic.baseproject.helpers.listeners.OnClickListeners.setSafeOnClickListener
import com.orbitalsonic.baseproject.helpers.utils.ExtensionFunctions.findNavControllerSafely
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
            onClickMethods()
            "home_screen".postEvent()
        }
    }

    private fun onClickMethods() {
        binding.btnDetails.setSafeOnClickListener {
            if (findNavControllerSafely()?.currentDestination?.id == R.id.homeFragment){
                lifecycleScope.launchWhenCreated {
                    view?.post {
                        val action = HomeFragmentDirections.actionHomeFragmentToSampleDetailsFragment()
                        findNavControllerSafely()?.navigate(action)
                    }
                }

            }
        }
    }

}