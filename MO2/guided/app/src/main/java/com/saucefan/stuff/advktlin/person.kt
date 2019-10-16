package com.saucefan.stuff.advktlin

class Person (var name:String, val age:Int) {


    operator fun unaryPlus() {
        this.name += "unary"
    }
    fun plus(other:Person):String {
        return this.name +other.name
    }
}