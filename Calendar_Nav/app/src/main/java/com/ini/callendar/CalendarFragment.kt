package com.ini.callendar

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ini.callendar.adapter.CalendarAdapter
import com.ini.callendar.databinding.FragmentCalendarBinding
import java.time.LocalDate
import java.util.*


class CalendarFragment : Fragment() {

    private val TAG = javaClass.simpleName
    lateinit var mContext: Context

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    var pageIndex = 0
    lateinit var currentDate: LocalDate
//    lateinit var currentDate: Date

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
        Log.d("이거뭐야, onCreateView", "Calender Index : $pageIndex")
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        initView(inflater.inflate(R.layout.fragment_calendar, container, false))
        initCalendar()
        return binding.root
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
//        initView(view)
//        initCalendar()
//        return view
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun initView(view: View) {
        pageIndex -= (Int.MAX_VALUE / 2)
        Log.e(TAG, "Calender Index: $pageIndex")
        calendar_year_month_text = binding.calendarYearMonthText
        calendar_layout = binding.calendarLayout
        calendar_view = binding.calendarView

        // 날짜 적용
//        val date = Calendar.getInstance().run {
//            add(Calendar.MONTH, pageIndex)
//            time
//        }
//        currentDate = date
//        Log.d("이거뭐야,date", "Calender Index: $date")
//        Log.e( "날짜 확인하기", "$date")
//        Log.d("date.time", "Date.time은 뭐얏....: $date.time")

        // 포맷 적용
        // 1번
//        val date = Calendar.getInstance().time
//        currentTime = date

        // 2번
//        currentTime = Calendar.getInstance().time

        // java 1.8 이상
        val date_text = LocalDate.now()
        Log.d("현재 날짜는?", date_text.toString())
        currentDate = date_text

//        val date = Date.from(date_text.atStartOfDay(ZoneId.systemDefault()).toInstant())
//        Log.d("NullPoint", date.toString())
//        currentDate = date

//        val cur_time = LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        // SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault()).format(currentTime)

//        var datetime: String = SimpleDateFormat("YYYY년 MM월 D일", Locale.KOREA).format(System.currentTimeMillis())
//        Log.d("datetime", datetime)

        calendar_year_month_text.setText(date_text.toString())
    }

    fun initCalendar() {
        // 각 월의 1일의 요일을 구해
        // 첫 주의 일요일~해당 요일 전까지는 ""으로
        // 말일까지 해당 날짜
        // 마지막 날짜 뒤로는 ""으로 처리하여
        // CalendarAdapter로 List를 넘김
        calendarAdapter = CalendarAdapter(mContext, calendar_layout, currentDate)
        calendar_view.adapter = calendarAdapter
        calendar_view.layoutManager =
            GridLayoutManager(mContext, 7, GridLayoutManager.VERTICAL, false)
        calendar_view.setHasFixedSize(true)
        calendarAdapter.itemClick = object :
            CalendarAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val firstDateIndex = calendarAdapter.dataList.indexOf(1)
                val lastDateIndex =
                    calendarAdapter.dataList.lastIndexOf(calendarAdapter.furangCalendar.currentMaxDate)
                // 현재 월의 1일 이전, 현재 월의 마지막일 이후는 터치 disable
                if (position < firstDateIndex || position > lastDateIndex) {
                    return
                }
                val day = calendarAdapter.dataList[position].toString()
                val date = "${calendar_year_month_text.text}${day}일"
                Log.d(TAG, "$date")
//                val mainTab = mActivity.main_bottom_menu
//                mainTab.setScrollPosition(1, 0f, true)
//                val mainViewPager = mActivity.main_pager
//                mainViewPager.currentItem = 1
//                RoutineDateLiveData.getInstance().getLiveProgress().value = date
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

}