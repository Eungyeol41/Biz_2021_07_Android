package com.ini.callendar

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*

class FurangCalendar(date: LocalDate) {
    companion object {
        const val DAYS_OF_WEEK = 7
        const val LOW_OF_CALENDAR = 6
    }

    //    val calendar = Calendar.getInstance()
    lateinit var calendar: LocalDate

    var prevTail = 0
    var nextHead = 0
    var currentMaxDate = 0

    var dateList = arrayListOf<Int>()

    init {
//        calendar.time = date
        calendar = LocalDate.now()
    }

    fun initBaseCalendar() {
        makeMonthDate()
    }

    private fun makeMonthDate() {

        dateList.clear()

//        calendar.set(Calendar.DATE, 1)
//        currentMaxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
//        prevTail = calendar.get(Calendar.DAY_OF_WEEK) - 1
//        makePrevTail(calendar.clone() as Calendar)
//        makeCurrentMonth(calendar)

        // 현재월의 첫번째 일자 - use LocalDate
        val firstDate: LocalDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth())
        val firstDateString: String? = firstDate.format(DateTimeFormatter.ISO_DATE)
//        LocalDate firstDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
//        String firstDateString = firstDate.format(DateTimeFormatter.ISO_DATE);
//        System.out.println(firstDateString); // 2021-06-01


        // 현재월의 첫번째 월요일인 날짜.
//        LocalDate dateOfFirstMonday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
//        System.out.println(dateOfFirstMonday); // 2021-06-07
        val dateOfFirstMonday: LocalDate =
            LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))

//        nextHead = LOW_OF_CALENDAR * DAYS_OF_WEEK - (prevTail + currentMaxDate)
//        makeNextHead()
        makeCurrentMonth(calendar)
    }

    private fun makePrevTail(calendar: Calendar) {
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1)
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        var maxOffsetDate = maxDate - prevTail

        for (i in 1..prevTail) dateList.add(++maxOffsetDate)
    }

    private fun makeCurrentMonth(calendar: LocalDate) {
//        for (i in 1..calendar.getActualMaximum(Calendar.DATE)) dateList.add(i)

        // 현재월의 마지막 일자
//        LocalDate lastdDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
//        String lastDateString = lastdDate.format(DateTimeFormatter.ISO_DATE);
//        System.out.println(lastDateString); // 2021-06-30
        val lastDate: LocalDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth())
        val lastDateString: String? = lastDate.format(DateTimeFormatter.ISO_DATE)
    }

    private fun makeNextHead() {
        var date = 1

        for (i in 1..nextHead) dateList.add(date++)
    }
}