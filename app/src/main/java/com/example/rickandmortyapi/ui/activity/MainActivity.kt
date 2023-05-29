package com.example.rickandmortyapi.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationListener: OnBottomNavigationSelected

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupWithNavController(binding.bottomNavigation, navController)

        with(binding.bottomNavigation) {
            setupWithNavController(navController)
            setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.characterFragment,
                    R.id.episodeFragment,
                    R.id.locationFragment
                    -> {
                        bottomNavigationListener.onItemSelect()
                    }
                }
            }
        }
    }

    fun interface OnBottomNavigationSelected {
        fun onItemSelect()
    }
    fun setOnItemReselectedListener(bottomNavigationListener: OnBottomNavigationSelected) {
        this.bottomNavigationListener = bottomNavigationListener
    }
}
