package com.orbitalsonic.baseproject.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.orbitalsonic.baseproject.BuildConfig
import com.orbitalsonic.baseproject.R
import com.orbitalsonic.baseproject.databinding.ActivityMainBinding
import com.orbitalsonic.baseproject.helpers.listeners.OnClickListeners.setSafeOnClickListener
import com.orbitalsonic.baseproject.helpers.utils.GeneralUtils.feedback
import com.orbitalsonic.baseproject.helpers.utils.GeneralUtils.privacyPolicy
import com.orbitalsonic.baseproject.helpers.utils.GeneralUtils.rateUs
import com.orbitalsonic.baseproject.helpers.utils.GeneralUtils.shareApp

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.includeToolbar.toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_main) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment), binding.drawerLayout
        )

        binding.navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        initListener()
        initNavDrawerListener()


    }

    private fun initListener() {

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.sampleDetailsFragment -> {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                R.id.homeFragment -> {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }

            }

        }

    }

    @SuppressLint("SetTextI18n")
    private fun initNavDrawerListener() {

        binding.includeDrawer.navVersionName.text = "Version " + BuildConfig.VERSION_NAME

        binding.includeDrawer.navPrivacyPolicy.setSafeOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            privacyPolicy()
        }

        binding.includeDrawer.navShareApp.setSafeOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            shareApp()
        }

        binding.includeDrawer.navRateUs.setSafeOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            rateUs()
        }

        binding.includeDrawer.navFeedback.setSafeOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            feedback()
        }

        binding.includeDrawer.navUpdateApp.setSafeOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            rateUs()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (navController.currentDestination?.id == R.id.homeFragment){
                showExitDialog()
            }else{
                onBack()
            }

        }
    }

    private fun onBack() {
        super.onBackPressed()
    }


    private fun showExitDialog( ) {

    }


}