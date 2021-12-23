package com.ini.weekcalendar.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ini.weekcalendar.R
import com.ini.weekcalendar.adapter.CalendarAdapter
import com.ini.weekcalendar.data.model.Calendar
import com.ini.weekcalendar.databinding.FragmentHomeBinding
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var calendarAdapter: CalendarAdapter
    private var cList = ArrayList<Calendar>()

//    var week_textView: TextView = binding.weekTextview

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var week_day: Array<String> = resources.getStringArray(R.array.calendar_day)
        var week_day_en: Array<String> = resources.getStringArray(R.array.calendar_day_EN)

        calendarAdapter = CalendarAdapter(cList)
        cList.apply {
            val dateFormat = DateTimeFormatter.ofPattern("dd").withLocale(Locale.forLanguageTag("ko"))

//            var preSunday: LocalDateTime = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY))
            val preSunday: String = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).format(dateFormat)
//            preSunday = "26"

            for (i in 0..6) {
                Log.d("오늘은 몇요일..?", week_day[i])

//                Log.d("plusDays", preSunday.plusDays(i.toLong()).format(dateFormat))
//                add(Calendar(preSunday.plusDays(i.toLong()).format(dateFormat), week_day[i]))
                Log.d("plus", preSunday.toInt().plus(i.toLong()).toString())
            }

        }

        binding.calendarRecyclerview.adapter = calendarAdapter
        binding.calendarRecyclerview.layoutManager = GridLayoutManager(context, 7)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}