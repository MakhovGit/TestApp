package com.example.app.testapp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.app.testapp.R
import com.example.app.testapp.core.extensions.ZERO
import com.example.app.testapp.databinding.ActivityMainBinding
import com.example.app.testapp.navigation.data.navigation.MainNavigation

class MainActivity : AppCompatActivity(), MainNavigation {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val navList = mutableListOf(
        R.id.navigation_onboarding,
        R.id.navigation_login,
        R.id.navigation_main,
        R.id.navigation_favorites,
        R.id.navigation_account
    )
    private val showBottomMenuList = listOf(
        R.id.navigation_main,
        R.id.navigation_favorites,
        R.id.navigation_account
    )

    private fun bottomMenuHide() {
        binding.activityBottomNavigation.visibility = View.GONE
        binding.activityDivider.visibility = View.GONE
    }

    private fun bottomMenuShow() {
        binding.activityBottomNavigation.visibility = View.VISIBLE
        binding.activityDivider.visibility = View.VISIBLE
    }

    private fun setDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in showBottomMenuList) {
                bottomMenuShow()
            } else {
                bottomMenuHide()
            }
        }
    }

    private fun setInsetsListener() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(binding.root.id)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, Int.ZERO)
            insets
        }
    }

    private fun checkPreferences() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val isFirstStart = sharedPref.getBoolean(FIRST_START_KEY, DEFAULT_PREF_VALUE)
        if (isFirstStart.not()) {
            navList.removeAt(Int.ZERO)
        } else {
            sharedPref.edit {
                putBoolean(FIRST_START_KEY, false)
            }
        }
    }

    private fun setupNavController(navList: List<Int>) {
        val navHostFragment = binding.activityFragmentContainer.getFragment<NavHostFragment>()
        navController = navHostFragment.navController
        val graph = navController.navInflater.inflate(R.navigation.navigation_main)
        graph.setStartDestination(navList.first())
        navController.graph = graph
        setDestinationListener()
        binding.activityBottomNavigation.setupWithNavController(navController)
    }

    override fun openLoginScreen() {
        navController.navigate(R.id.navigation_login)
    }

    override fun openMainScreen() {
        navController.navigate(R.id.navigation_main)
    }

    override fun openFavoritesScreen() {
        navController.navigate(R.id.navigation_favorites)
    }

    override fun openAccountScreen() {
        navController.navigate(R.id.navigation_account)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setInsetsListener()
        checkPreferences()
        setupNavController(navList = navList)
    }

    private companion object {
        const val FIRST_START_KEY = "FIRST_START"
        const val DEFAULT_PREF_VALUE = true
    }

}