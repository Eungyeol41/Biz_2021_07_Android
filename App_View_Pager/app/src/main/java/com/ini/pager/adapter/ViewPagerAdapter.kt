package com.ini.pager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ini.pager.ui.dashboard.DashboardFragment
import com.ini.pager.ui.notifications.NotificationsFragment
import java.lang.IndexOutOfBoundsException

const val DASHBOARD_INDEX = 0
const val NOTIFICATION_INDEX = 1

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // DashBoard, Notification fragment를 Map type으로 묶어서 pageTabList에 담기
    private val pageTabList: Map<Int, () -> Fragment> =
        mapOf(
            DASHBOARD_INDEX to { DashboardFragment() },
            NOTIFICATION_INDEX to { NotificationsFragment() }
        )

    override fun getItemCount(): Int {
        return pageTabList.size
    }

    override fun createFragment(position: Int): Fragment {
        // invoke: 실행하는 역할
        // pageTabList에서 XX_INDEX를 뒤의 XXFragment에서 실행시킨다!
        return pageTabList[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}