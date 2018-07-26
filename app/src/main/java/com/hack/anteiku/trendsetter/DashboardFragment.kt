package com.hack.anteiku.trendsetter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hack.anteiku.trendsetter.BottomNavigationDrawerFragment.Companion.TAG_MAP
import com.hack.anteiku.trendsetter.BottomNavigationDrawerFragment.Companion.TAG_TOURIST_DISTRIBUTION
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {

    private lateinit var bottomNavigationDrawerFragment: BottomNavigationDrawerFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val itemView = inflater.inflate(R.layout.fragment_dashboard, container, false)

        itemView.cardMap.setOnClickListener { bottomNavigationDrawerFragment.switchFragment(TAG_MAP) }
        itemView.cardPieChart.setOnClickListener { bottomNavigationDrawerFragment.switchFragment(TAG_TOURIST_DISTRIBUTION) }

        return itemView
    }

    companion object {

        @JvmStatic
        fun newInstance(bottomNavigationDrawerFragment: BottomNavigationDrawerFragment) = DashboardFragment().apply {
            this.bottomNavigationDrawerFragment = bottomNavigationDrawerFragment
        }
    }
}
