package com.ini.weekcalendar.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ini.weekcalendar.R
import com.ini.weekcalendar.data.model.Calendar
import com.ini.weekcalendar.databinding.ItemCalendarBinding
import com.ini.weekcalendar.ui.home.HomeFragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CalendarAdapter(private val cList: List<Calendar>):RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    private var homeFragment= HomeFragment()

    class CalendarViewHolder(private val binding: ItemCalendarBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Calendar) {
            binding.date.text = item.c_date
            binding.day.text = item.c_day

            var today = binding.date.text

            val now = LocalDate.now().format(DateTimeFormatter.ofPattern("dd").withLocale(Locale.forLanguageTag("ko")))

            Log.d("today", "$today")

            if (today == now) {
            binding.weekCardview.setBackgroundResource(R.drawable.bg_custom_box)
            }
//            binding.date.setBackgroundResource()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = ItemCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(cList[position])
    }

    override fun getItemCount(): Int {
        return cList.size
    }


}