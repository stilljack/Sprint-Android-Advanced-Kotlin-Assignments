package com.saucefan.stuff.unrequestionreplacementforfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

class ChildController<T: Controller>(targetController: Controller) : BaseCtrler() {
    constructor(arg: Bundle,controller: Controller) : this(controller) {
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.activity_main,container,false)
    }
interface dataPassController{
    fun recieveMsG(int:Int)
}

}