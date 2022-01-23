package com.anatame.motiontransform

import android.graphics.ComposeShader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.anatame.motiontransform.databinding.ActivityMainBinding
import com.google.android.material.transition.MaterialElevationScale


import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.transition.MaterialSharedAxis


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val currentNavigationFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
            ?.childFragmentManager
            ?.fragments
            ?.first()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            fab.setOnClickListener{
                onFabClicked()
            }
        }

        navController = findNavController(R.id.nav_host_fragment_activity_main)
    }

    fun onFabClicked(){
        currentNavigationFragment?.apply {
            exitTransition = MaterialElevationScale(false).apply {
                duration = 300
            }
            reenterTransition = MaterialElevationScale(true).apply {
                duration = 300
            }
        }
        val directions = ComposeFragmentDirections.actionGlobalComposeFragment()
        findNavController(R.id.nav_host_fragment_activity_main).navigate(directions)
    }

    fun navigateToSearch(){
        currentNavigationFragment?.apply {
            exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply {
                duration = 300
            }
            reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false).apply {
                duration = 300
            }
            val directions = SearchFragmentDirections.actionGlobalSearchFragment()
            findNavController(R.id.nav_host_fragment_activity_main).navigate(directions)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "Take me to search", Toast.LENGTH_SHORT).show()
                navigateToSearch()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}