package com.saucefan.stuff.advktlin

import android.view.View

fun MutableList<Int>.swap(index1:Int,index2:Int) {
    val tmp=index1
    this[index1]=index2
    this[index2]=index1

}

fun Int.isEven():Boolean {
    return this %2 ==0
}

fun List<Person>.lookForAlice():Boolean {

    return  this.any{
        it.name=="alice"}
}

fun List<Person>.findAlice():Person? {

    return  this.find{
        it.name=="alice"}
}

fun List<Any>.dumb(){
    this == listOf<Int>(1,2)
}

fun View.visble() {
    this.visibility =View.VISIBLE
}
fun View.hidden() {
    this.visibility =View.INVISIBLE
}