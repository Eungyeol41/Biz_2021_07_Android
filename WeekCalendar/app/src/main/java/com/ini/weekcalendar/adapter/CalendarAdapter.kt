package com.ini.weekcalendar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ini.weekcalendar.data.model.Calendar
import com.ini.weekcalendar.databinding.ItemCalendarBinding

class CalendarAdapter(private val cList: List<Calendar>):RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    class CalendarViewHolder(private val binding: ItemCalendarBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Calendar) {
            binding.date.text = item.c_date
            binding.day.text = item.c_day
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