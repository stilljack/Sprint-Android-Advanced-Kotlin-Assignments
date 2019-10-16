package com.saucefan.stuff.guided

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
lateinit var toastString:String

    private var custom:Int =0
    get() {

        return when {
            field ==0 -> field
            field>0 -> 1
            else -> -1
        }
    }
    set(value) {
        field =value
        this.showToast("custom is noew $field")
    }

    val textView by lazy {
        findViewById<TextView>(R.id.view1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text=custom.toString()
        textView.text="test2"

    }

    override fun onStart() {
        super.onStart()
        toastString="init"
btn1.setOnClickListener { this.showToast(custom.toString()) }
btn2.setOnClickListener { custom= Random.nextInt() }
    }


}

fun Context.showToast(message:String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
