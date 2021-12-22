package com.ini.callendar.ui.dashboard

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ini.callendar.R
import com.ini.callendar.databinding.FragmentDashboardBinding
import com.ini.callendar.databinding.WeekCalendarBinding
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: WeekCalendarBinding? = null
    private val binding get() = _binding!!

    private var localDate: LocalDateTime = LocalDateTime.now()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = WeekCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val sunday: TextView = binding.sundayNum
        val monday: TextView = binding.mondayNum
        val wendsday: TextView = binding.wednesdayNum
        val saturday: TextView = binding.saturdayNum
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val preSunday: LocalDateTime =
            LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY))
        val start_sunday = preSunday.format(DateTimeFormatter.ofPattern("dd"))
        Log.d("이번 주 일요일", preSunday.toString())
        Log.d("이번 주 일요일 format", start_sunday)

        val preMonday: LocalDateTime =
            LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY))
        val start_monday = preMonday.format(DateTimeFormatter.ofPattern("dd"))

        sunday.setText(start_sunday)
        monday.setText(start_monday)
        wendsday.setText(start_sunday+3)
        saturday.setText(start_sunday+6)


        val nextSunday: LocalDateTime =
            LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY))
//        preSunday.format("d", )
        Log.d("다음 주 일요일", nextSunday.toString())
//        sunday.setText(now)

//        var week_day:Array<String> = resources.getStringArray(R.array.week_day)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}