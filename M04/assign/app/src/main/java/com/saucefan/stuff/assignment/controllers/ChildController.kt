package com.saucefan.stuff.assignment.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.saucefan.stuff.assignment.R
import kotlin.random.Random

class ChildController<T>() : BaseCtrler()
   where T:Controller, T:ChildController.dataPassController
{

constructor(targetController: T): this()
     {
        setTargetController(targetController)
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
        val btn1 = view?.findViewById<Button>(R.id.btn2_second)
        val btn2 = view?.findViewById<Button>(R.id.btn2_second)
       btn1?.text="set parent text"
         btn1?.setOnClickListener {
             (targetController as dataPassController).recieveMSG(Random.nextInt())
         }
            btn2?.setOnClickListener { }


    }



}