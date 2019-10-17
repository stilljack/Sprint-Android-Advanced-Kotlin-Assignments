package com.saucefan.stuff.unrequestionreplacementforfragments


import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.NonNull
import com.bluelinelabs.conductor.Controller


class HomeController : Controller() {

    override fun onCreateView(@NonNull inflater: LayoutInflater, @NonNull container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        (view.findViewById(R.id.tv_title) as TextView).text = "Hello World"
        return view
    }

}