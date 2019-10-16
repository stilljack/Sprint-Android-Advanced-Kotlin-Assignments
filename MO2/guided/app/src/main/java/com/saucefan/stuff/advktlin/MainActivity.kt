package com.saucefan.stuff.advktlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
companion object {
    fun thisdumbol():Boolean{
        return true
    }
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var mutableList = mutableListOf<Int>(0,1,2,3,4)
        val num =Person("sauce",13)

        kas2.setOnClickListener {
            +num
         if (kas.visibility== View.VISIBLE) {
             kas.hidden()
         }   else {kas.visble()}
        }

        kas.setOnClickListener {
mutableList.dumb()
            +num
            Toast.makeText(this,"${num.name} ${mutableList.swap(1,2)}",Toast.LENGTH_SHORT).show()

        }


    }

}
