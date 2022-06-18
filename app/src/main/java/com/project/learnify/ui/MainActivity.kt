package com.project.learnify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.learnify.*
import com.project.learnify.adapter.CourseAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflate the layout
        menuInflater.inflate(R.menu.layout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.contact_us){
            var a = supportFragmentManager.beginTransaction()
            var b = ContactFragment()
            a.replace(R.id.fragmentContainerView, b)
            a.commit()
        }
        else if (item.itemId == R.id.about_us){
            var a = supportFragmentManager.beginTransaction()
            var b = AboutFragment()
            a.replace(R.id.fragmentContainerView, b)
            a.commit()
        }
        else if (item.itemId == R.id.change_layout) {
            var a = supportFragmentManager.beginTransaction()
            var b = LayoutFragment()
            a.replace(R.id.fragmentContainerView, b)
            a.commit()
        }
        return  super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}