package com.example.newsnow

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsnow.database.ArticleDatabase
import com.example.newsnow.repository.NewsRepository
import com.example.newsnow.ui.viewmodel.NewsViewModel
import com.example.newsnow.ui.viewmodel.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configBottomNav()
        configNavDrawer()

        //Instanciando as parada
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Perfil -> Toast.makeText(
                    applicationContext,
                    "Clicked item", Toast.LENGTH_LONG
                )
                    .show()
                R.id.Settings -> Toast.makeText(
                    applicationContext,
                    "Clicked item",
                    Toast.LENGTH_LONG
                )
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.articleDetailsFragment -> showBottomNav()
                R.id.newsFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun configNavDrawer() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.articleDetailsFragment -> showNavDrawer()
                R.id.newsFragment -> showNavDrawer()
                else -> hideNavDrawer()
            }
        }
    }

    private fun showNavDrawer() {
        navView.visibility = View.VISIBLE
    }

    private fun hideNavDrawer() {
        navView.visibility = View.GONE
    }

    private fun showBottomNav() {
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        bottomNavigationView.visibility = View.GONE
    }

}
