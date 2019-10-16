package com.lambdaschool.android.androidnavigationdrawer


class HackerRank {

    infix fun Int.fdiv(i: Int): Double = this / i.toDouble();
    fun plusMinus(arr: Array<Int>) {
        var pos: Int = 0
        var neg: Int = 0
        var zero: Int = 0
        val size = arr.size
        for (num in arr) {
            if (num > 0) {
                pos += 1
            } else if (num < 0) {
                neg += 1
            } else if (num == 0) {
                zero += 1
            }
        }

        var finalPos = (pos.toDouble() / size)
        var finalNeg = (neg fdiv size)
        var finalZero:Double = (zero fdiv size)
        println(finalPos.toString())
        println(finalNeg.toString())
        println(finalZero.toString())


    }

    fun staircase(n: Int): Unit {
        var finalStr = ""
        var interimStr = ""
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (j > n - i - 1) {
                    finalStr += "#"
                } else {
                    finalStr += " "
                }
            }
            finalStr += "\n"
        }
    println(finalStr)
    }

    fun miniMaxSum(arr: Array<Int>): Unit {
            arr.sortDescending()
        var a = 0
        var b = 0
        for (i in arr.indices) {
            if(i!=0) {b+=arr[i]}
            if (i!=arr.size) {a+=arr[i]}

        }
        println("$a $b")
    }

    fun birthdayCakeCandles(ar: Array<Int>): Int {
        var top=0
        var total=0
        ar.sortDescending()

        for (item in ar){
            if (top==0){
                top=item
            }
            if (top==item) {
                total++
            }

        }
return total
    }


    fun timeConversion(s: String): String {
        var final =""
        var inter = ""

        if (s.takeLast(2) =="PM"){
            if (s.take(2)=="12") {
                final = "00"
                inter = s
                inter = inter.dropLast(2)
                final += inter.removePrefix(s.take(2))
            }
            else {
                final = (s.take(2).toInt() + 12).toString()
                inter = s
                inter = inter.dropLast(2)
                final += inter.removePrefix(s.take(2))
            }
            }
            else {
            if (s.take(2)=="12") {
                final = "12"
                inter = s
                inter = inter.dropLast(2)
                final += inter.removePrefix(s.take(2))
            }
            else {
                final = s.dropLast(2)
            }
            }


        return final

    }

    fun camelcase(s: String): Int {
        var final = 1
        for (i in s.indices) {
            if (s[i].category == CharCategory.UPPERCASE_LETTER) {
                final++
            }
        }
        return final
        }

    fun minimumNumber(n: Int, password: String): Int {
        // Return the minimum number of characters to make the password strong
        //upper,lower, number, an acceptable !@#$%^&*()-+,
        val charArr =password.toCharArray()
        var finalNeeded =0
        var upper:Boolean= false
        var lower:Boolean =false
        var number:Boolean= false
        var spec:Boolean=false
        var specRegex= "[!@#\$%^&*()-+,]".toRegex()
        var numbersRegex = "0123456789".toRegex()
       var  lower_caseRegex = "abcdefghijklmnopqrstuvwxyz".toRegex()
        var upper_caseRegex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toRegex()
        if(specRegex.containsMatchIn(password)) {spec=true} else {finalNeeded++}
        if(numbersRegex.containsMatchIn(password)) {number=true}else {finalNeeded++}
        if(lower_caseRegex.containsMatchIn(password)) {lower=true}else {finalNeeded++}
        if(upper_caseRegex.containsMatchIn(password)) {upper=true}else {finalNeeded++}

        if (spec and number and lower and upper && n>=6) {
                return 0
        }
        else {
            if (finalNeeded>= 6-n) {
                return finalNeeded
            }
            else {
                return 6-n
            }
        }



    }

}

