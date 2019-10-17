package com.saucefan.stuff.unrequestionreplacementforfragments


import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.widget.Button
import androidx.annotation.NonNull
import com.bluelinelabs.conductor.*
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler


class HomeController : Controller() {
 val horizontalChangeHandler =HorizontalChangeHandler()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        (view.findViewById(R.id.tv_title) as TextView).text = "i'm da joker baby.txt backstack size =${router.backstackSize}"
        return view
    }
    protected override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        setButtonsEnabled(true)

        val btnView=view?.findViewById<Button>(R.id.btn)
        val btnView2 =view?.findViewById<Button>(R.id.btn2)
        btnView?.setOnClickListener {
            router.pushController(RouterTransaction.with(HomeController())
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )

        }
        if (router.backstackSize == 0){
            btnView2?.visibility =  INVISIBLE
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