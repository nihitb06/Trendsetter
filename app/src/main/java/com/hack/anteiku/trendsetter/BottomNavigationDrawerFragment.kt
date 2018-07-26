package com.hack.anteiku.trendsetter

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_bottom_navigation_drawer.view.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment (), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var switchFragment: (fragment: Fragment) -> Unit
    private lateinit var itemView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val itemView = inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false)

        this.itemView = itemView
        itemView.navBarMain.setNavigationItemSelectedListener(this)
        setChecked(itemView.navBarMain.menu.findItem(R.id.dashboard))

        return itemView
    }

    fun switchFragment(tag: String) {
        when (tag) {
            TAG_DASHBOARD -> onNavigationItemSelected((itemView.navBarMain as NavigationView).menu.findItem(R.id.dashboard))
            TAG_MAP -> switchFragment(MapFragment.newInstance())
            TAG_TOURIST_DISTRIBUTION -> switchFragment(TouristDistributionFragment.newInstance())
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId) {
            R.id.dashboard -> {
                switchFragment(DashboardFragment.newInstance(this))
            }
            R.id.viewMap -> {
                switchFragment(MapFragment.newInstance())
            }
            else -> { dismiss(); return false }
        }

        setChecked(menuItem)
        dismiss()
        return true
    }

    private fun setChecked(item: MenuItem) {
        Handler().post {
            for(index in 0 until itemView.navBarMain.menu.size())
                itemView.navBarMain.menu.getItem(index).isChecked = false

            item.isChecked = true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(
                switchFragment: (fragment: Fragment) -> Unit
        ) = BottomNavigationDrawerFragment().apply {
            this.switchFragment = switchFragment
        }


        const val TAG_DASHBOARD = "Dashboard"
        const val TAG_MAP = "Map"
        const val TAG_TOURIST_DISTRIBUTION = "TouristDistribution"
        const val TAG_PREDICT = "Predict"
    }
}