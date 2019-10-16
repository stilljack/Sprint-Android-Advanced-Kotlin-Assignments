package com.saucefan.stuff.guided

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
lateinit var toastString:String
    lateinit var marineMammals: List<MarineMammals>

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

    var listType:MarineMammals by Delegates.observable(whale("sauce")) {
            _,_:MarineMammals,new:MarineMammals ->
        marineMammals = when(new) {
            is whale->whales
            is Dolphin->dolphins
                is porpoise->otters
        }
        textView.text=marineMammals.joinToString (","){  }
    }
    private val whales = listOf(
        whale("Blue"),
        whale("Humpback"),
        whale("Whale Shark")
    )
    private val dolphins = listOf(
        Dolphin("Bottlenose"),
        Dolphin("Amazon river dolphin"),
        Dolphin("Dan Marino")
    )
    private val otters = listOf(
        porpoise("Sea otter"),
        porpoise("Marine otter"),
        porpoise("Emmett otter and his jug band")
    )

    val textView by lazy {
        findViewById<TextView>(R.id.view1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text=custom.toString()

    }

    override fun onStart() {
        super.onStart()
        toastString="init"
btn1.setOnClickListener {
    //this.showToast(custom.toString())
    //
    // }
listType= listOf<MarineMammals>(whale("w1"),dolphins("d1"),otters("o1")).random()
}
btn2.setOnClickListener { custom= Random.nextInt() }
    }
 private inline fun  <reified T:MarineMammals> setTitleForType(mammalKust: List<T>) {
     when {
         whale("w") is T -> this.title="whales"
         Dolphin("d") is T -> this.title="Dolphin"
         porpoise("p") is T ->this.title="porpoise"

     }

 }

}

fun Context.showToast(message:String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
