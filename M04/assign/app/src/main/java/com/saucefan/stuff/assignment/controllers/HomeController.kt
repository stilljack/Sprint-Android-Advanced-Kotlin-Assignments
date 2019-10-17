package com.saucefan.stuff.assignment.controllers


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.saucefan.stuff.assignment.R
import org.w3c.dom.Text


class HomeController (var communicatedString:String? =null) : BaseCtrler(),ChildController.dataPassController {
    override fun recieveMSG(int: Int) {
        communicatedString += "$int"
        (view?.findViewById<TextView>(R.id.tv_first))?.text=communicatedString
    }

    val horizontalChangeHandler =HorizontalChangeHandler()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.first, container, false)
        (view.findViewById(R.id.tv_first) as TextView).text = "i'm da joker baby.txt backstack size =${communicatedString}"
        return view
    }

    fun getMessage(string: String?):String? {
        return communicatedString
    }

    protected override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        setButtonsEnabled(true)

        val btnView=view?.findViewById<Button>(R.id.btn_first)
        val btnView2 =view?.findViewById<Button>(R.id.btn2_first)
        btnView?.setOnClickListener {
            /*router.pushController(RouterTransaction.with(HomeController(router.backstackSize.toString()))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )*/recieveMSG(6)
            router.pushController(RouterTransaction.with(ChildController(this ))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }
        if (router.backstackSize <= 1){
            btnView2?.isEnabled =false
        } else {
            btnView?.text=communicatedString
            val sauce =targetController
            targetController?.view?.setBackgroundColor(Color.BLUE)

        }
        btnView2?.setOnClickListener {
            router.popCurrentController()
        }
    }

    protected override fun onChangeStarted(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeStarted(changeHandler, changeType)

        setButtonsEnabled(false)
    }
    private fun setButtonsEnabled(enabled: Boolean) {
        val view = view
        if (view != null) {
            (enabled)
        }


    }

}