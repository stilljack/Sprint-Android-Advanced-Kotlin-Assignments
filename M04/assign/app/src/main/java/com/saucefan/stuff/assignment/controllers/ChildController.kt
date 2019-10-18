package com.saucefan.stuff.assignment.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.saucefan.stuff.assignment.EXTRA_STRING
import com.saucefan.stuff.assignment.R
import kotlin.random.Random

class ChildController<T>(bundle: Bundle) : BaseCtrler(bundle)
   where T:Controller, T:ChildController.dataPassController
{

constructor(targetController: T,bundle: Bundle): this(bundle)
     {
        setTargetController(targetController)
    }
    val communicatedString by lazy {
        args.getString(EXTRA_STRING)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.second,container,false)
    }
interface dataPassController{
    fun recieveMSG(int:Int)
}

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        val btn1 = view?.findViewById<Button>(R.id.btn_second)
        val btn2 = view?.findViewById<Button>(R.id.btn2_second)
        val tv =view?.findViewById<TextView>(R.id.tv_second)
        tv?.text = "(${communicatedString})"
       btn1?.text="set parent text"
        btn2?.text="go back "
         btn1?.setOnClickListener {


             (targetController as HomeController).recieveMSG(Random.nextInt())
         }
            btn2?.setOnClickListener {
                router.popCurrentController()
            }


    }



}