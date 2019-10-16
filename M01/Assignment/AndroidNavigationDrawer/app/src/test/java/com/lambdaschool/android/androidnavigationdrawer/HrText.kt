package com.lambdaschool.android.androidnavigationdrawer

import org.junit.Test

class HrTest {
    @Test
    fun testPlusMinus(){

        val hr =HackerRank()
        val arr = arrayOf<Int>(-4, 3, -9, 0, 4, 1)
        hr.plusMinus(arr)
        assert(0==0)
    }
    @Test
    fun testStairs(){

        val hr =HackerRank()
        val arr = 6
        hr.staircase(arr)
        assert(0==0)
    }
    @Test
    fun testTime(){

        val hr =HackerRank()
        val arr = 6
        hr.timeConversion("06:06:06AM")
        hr.timeConversion("06:06:06PM")
        assert(0==0)
    }

}