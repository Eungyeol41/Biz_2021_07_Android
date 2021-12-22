package com.ini.callendar.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ini.callendar.CalendarFragment
import java.util.*
import kotlin.math.abs

class NotificationAdapter : FragmentStateAdapter {

    companion object {
        const val START_POSITION = Int.MAX_VALUE / 2
    }

    constructor(fragmentActivity: FragmentActivity) : super(fragmentActivity)
    constructor(fragment: Fragment) : super(fragment)
    constructor(fragmentManager: FragmentManager, lifecycle: Lifecycle) : super(
        fragmentManager,
        lifecycle
    )


    override fun getItemCount(): Int = Int.MAX_VALUE
    override fun getItemId(position: Int): Long {
        val cal = Calendar.getInstance()
        var currentYear = cal.get(Calendar.YEAR)
        var currentMonth = cal.get(Calendar.MONTH) + 1


        val move = position - START_POSITION
        val bias = if (move < 0) -1 else 1

        val moveYear = abs(move) / 12 * bias
        val moveMonth = abs(move) % 12 * bias

        currentYear += moveYear
        when {
            (currentMonth + moveMonth) < 1 -> {
                currentMonth = 12 + (currentMonth + moveMonth)
                currentYear--
            }
            (currentMonth + moveMonth) > 12 -> {
                currentMonth = (currentMonth + moveMonth) - 12
                currentYear++
            }
            else -> {
                currentMonth = (currentMonth + moveMonth)
            }
        }

        return (currentYear * 100 + currentMonth).toLong()
    }

    override fun containsItem(itemId: Long): Boolean = 200000L < itemId && itemId < 210001L


    override fun createFragment(position: Int): Fragment {
        val itemId = getItemId(position)
        return CalendarFragment().apply {
            arguments = Bundle().apply {
                putLong("year", itemId / 100L)
                putLong("month", itemId % 100L)
            }
        }
    }

}