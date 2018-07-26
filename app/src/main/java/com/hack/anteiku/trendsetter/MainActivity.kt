package com.hack.anteiku.trendsetter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.mapbox.mapboxsdk.Mapbox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationDrawerFragment: BottomNavigationDrawerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottomAppBar)
        bottomNavigationDrawerFragment = BottomNavigationDrawerFragment.newInstance { fragment: Fragment ->
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
        }
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DashboardFragment.newInstance(bottomNavigationDrawerFragment)).commit()

        Mapbox.getInstance(applicationContext, getString(R.string.mapbox_access_token))

        fabProject.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, PredictFragment.newInstance()).commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when(item?.itemId) {
            android.R.id.home -> {
                bottomNavigationDrawerFragment.show(supportFragmentManager, bottomNavigationDrawerFragment.tag)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
