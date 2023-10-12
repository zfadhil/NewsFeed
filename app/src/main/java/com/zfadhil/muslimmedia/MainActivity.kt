package com.zfadhil.muslimmedia

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.tabs.TabLayoutMediator
import com.zfadhil.muslimmedia.adapter.SectionPagerAdapter
import com.zfadhil.muslimmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        binding.vpContainer.adapter = SectionPagerAdapter(this)
        val listFragment = arrayOf("Home", "Hot", "Indonesia", "Viral")

        TabLayoutMediator(binding.tabLayout, binding.vpContainer) { tab, position ->
            tab.text = listFragment[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchView = menu?.findItem(R.id.option_search)?.actionView as SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as  SearchManager
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_search -> onSearchRequested()
            else -> super.onOptionsItemSelected(item)
        }
    }
}