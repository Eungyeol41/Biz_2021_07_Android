package com.ini.callendar

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ini.callendar.adapter.CalendarAdapter
import com.ini.callendar.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment(Index : Int) : Fragment() {

    private val TAG = javaClass.simpleName
    lateinit var mContext: Context

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    var pageIndex = 0
    lateinit var currentDate: Date

    lateinit var calendar_year_month_text: TextView
    lateinit var calendar_layout: LinearLayout
    lateinit var calendar_view: RecyclerView
    lateinit var calendarAdapter: CalendarAdapter

    companion object {
        var instance: CalendarFragment? = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mContext = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("이거뭐야, onCreateView", "Calender Index : $pageIndex")
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)

//        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        initView()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun initView() {
        pageIndex -= (Int.MAX_VALUE / 2)
        Log.d("이거뭐야", "Calender Index")
        Log.e(TAG, "Calender Index: $pageIndex")
        Log.d("이거뭐야", "Calender Index: $pageIndex")
        calendar_year_month_text = binding.calendarYearMonthText
        calendar_layout = binding.calendarLayout
        calendar_view = binding.calendarView

        // 날짜 적용
        val date = Calendar.getInstance().run {
            add(Calendar.MONTH, pageIndex)
            time
        }
        currentDate = date
        Log.d("이거뭐야,date", "Calender Index: $date")
        Log.e(TAG, "$date")
        // 포맷 적용
        var datetime: String = SimpleDateFormat("YYYY년 MM월", Locale.KOREA).format(System.currentTimeMillis())
        Log.d("date.time", "Date.time은 뭐얏....: $date.time")
        calendar_year_month_text.setText(datetime)
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }
}