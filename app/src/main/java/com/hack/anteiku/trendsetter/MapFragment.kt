package com.hack.anteiku.trendsetter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_map.view.*

class MapFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val itemView = inflater.inflate(R.layout.fragment_map, container, false)

        itemView.map.onCreate(savedInstanceState)
        itemView.map.getMapAsync {  }

        return itemView
    }

    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }
}
