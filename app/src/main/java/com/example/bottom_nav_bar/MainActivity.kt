package com.example.bottom_nav_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottom_nav_bar.databinding.ActivityMainBinding
import com.example.bottom_nav_bar.fragments.DashboardFragment
import com.example.bottom_nav_bar.fragments.InfoFragment
import com.example.bottom_nav_bar.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


private val dashboardFragment = DashboardFragment()
private val infoFragment = InfoFragment()
private val settingsFragment = SettingsFragment()


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavView: BottomNavigationView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        bottomNavView = binding.bottomNavigation


        setThatFragment(dashboardFragment)

        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.id_dashboard -> {
                    setThatFragment(dashboardFragment)
                }
                R.id.id_settings -> {
                    setThatFragment(settingsFragment)
                }
                R.id.id_info -> {
                    setThatFragment(infoFragment)
                }
            }
            true
        }

    }

    private fun setThatFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}