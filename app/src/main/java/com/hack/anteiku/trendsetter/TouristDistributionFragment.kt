package com.hack.anteiku.trendsetter


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_tourist_distribution.view.*

class TouristDistributionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val itemView = inflater.inflate(R.layout.fragment_tourist_distribution, container, false)

        val chartTouristDistribution = itemView.chartTouristDistribution
        val pieDataSet = PieDataSet(
                arrayListOf(
                        PieEntry(24.7f, "Foreign Overnight"),
                        PieEntry(18.3f, "Domestic Overnight"),
                        PieEntry(32.8f, "Foreign"),
                        PieEntry(24.2f, "Domestic")
                ),
                "Tourists Types"
        )
        pieDataSet.colors = arrayListOf(
                Color.BLUE,
                Color.YELLOW,
                Color.RED,
                Color.GREEN
        )

        chartTouristDistribution.data = PieData(pieDataSet)
        chartTouristDistribution.invalidate()

        return itemView
    }

    companion object {
        @JvmStatic
        fun newInstance() = TouristDistributionFragment()
    }
}
