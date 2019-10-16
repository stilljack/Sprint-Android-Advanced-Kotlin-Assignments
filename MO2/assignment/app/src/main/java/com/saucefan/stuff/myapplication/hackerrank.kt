package com.saucefan.stuff.myapplication

import java.lang.Integer.sum


fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
/*
    s: integer, starting point of Sam's house location.
    t: integer, ending location of Sam's house location.
    a: integer, location of the Apple tree.
    b: integer, location of the Orange tree.
    apples: integer array, distances at which each apple falls from the tree.
    oranges: integer array, distances at which each orange falls from the tree.
*/

    var samApples:Int =0
    var samOranges:Int =0
    apples.forEach {
        val fallLocation=a+it
        if (fallLocation>=s && fallLocation<=t){
            samApples++
        }
    }
    oranges.forEach {
        val fallLocation=b+it
        if (fallLocation>=s && fallLocation<=t){
            samOranges++
        }

    }
    println(samApples)
    print(samOranges)
}
fun reverseArray(a: Array<Int>): Array<Int> {
    var final = arrayOf<Int>()
    a.reversed().forEach{
        final.plus(it)
    }
    return final
}

fun hourglassSum(arr: Array<Array<Int>>): Int {
    val size =arr.size
    var listOfHourglassSums =mutableListOf<Int>()
    var final =-63
    for (j in 0 until 4){
        for (i in 0 until 4){
            val top = arr[i][j]+arr[i][j+1]+arr[i][j+2]
            val mid = arr[i+1][j+1]
            val bottom =arr[i+2][j]+  arr[i+2][j+1] +  arr[i+2][j+2]
            val newHourGlass = top+mid+bottom
            if (newHourGlass >final){final=newHourGlass}
            listOfHourglassSums.add(newHourGlass)

        }
    }
    val finallist=listOfHourglassSums.sortedDescending()
    val solution =  finallist[0]
    return final

}