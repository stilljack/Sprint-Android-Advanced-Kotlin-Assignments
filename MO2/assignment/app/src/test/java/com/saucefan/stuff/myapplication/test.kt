package com.saucefan.stuff.myapplication

import org.junit.Test

class Test(){

    @Test
    fun testo(){
        val arr = arrayOf<Array<Int>>(
            arrayOf<Int>(1, 1, 1, 0, 0, 0),
            arrayOf<Int>(0, 1, 0, 0, 0, 0),
            arrayOf<Int>(1, 1, 1, 0, 0, 0),
            arrayOf<Int>(0, 0, 2, 4, 4, 0),
            arrayOf<Int>(0, 0, 0, 2, 0, 0),
            arrayOf<Int>(0, 0, 1, 2, 4, 0))

        val sauce =hourglassSum(arr)
        val i=0
    }
}