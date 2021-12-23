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

        _binding = com.ini.callendar.databinding.WeekCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val sunday: TextView = binding.sundayNum
        val monday: TextView = binding.mondayNum
        val tuesday: TextView = binding.tuesdayNum
        val wednesday: TextView = binding.wednesdayNum
        val thursday: TextView = binding.thursdayNum
        val friday: TextView = binding.fridayNum
        val saturday: TextView = binding.saturdayNum

        val preSunday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY))
        val start_sunday = preSunday.format(DateTimeFormatter.ofPattern("dd"))
        Log.d("이번 주 일요일", preSunday.toString())
        Log.d("이번 주 일요일 format", start_sunday)

        val preMonday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY))
        val start_monday = preMonday.format(DateTimeFormatter.ofPattern("dd"))

        val preTuesday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.TUESDAY))
        val start_tuesday = preTuesday.format(DateTimeFormatter.ofPattern("dd"))

        val preWednesday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY))
        val start_wednesday = preWednesday.format(DateTimeFormatter.ofPattern("dd"))

        val preThursday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY))
        val start_thursday = preThursday.format(DateTimeFormatter.ofPattern("dd"))

        val preFriday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.FRIDAY))
        val start_friday = preFriday.format(DateTimeFormatter.ofPattern("dd"))

        val preSaturday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY))
        val start_saturday = preSaturday.format(DateTimeFormatter.ofPattern("dd"))

        sunday.setText(start_sunday)
        monday.setText(start_monday)
        tuesday.setText(start_tuesday)
        wednesday.setText(start_wednesday)
        thursday.setText(start_thursday)
        friday.setText(start_friday)
        saturday.setText(start_saturday)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}