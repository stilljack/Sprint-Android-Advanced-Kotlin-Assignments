package com.saucefan.stuff.myapplication.ui.main

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import com.saucefan.stuff.myapplication.*
import kotlinx.android.synthetic.main.main_fragment.*
import androidx.core.content.ContextCompat.getSystemService




class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contxt=view.context
        message.loadurl(view.context,"https://secure.gravatar.com/avatar/b2c23b4754ca437f9fa964c4dd183553?s=50&r=pg",message)
        val builder = NotificationCompat.Builder(contxt)
     //   notificationChannelInitialize(contxt)
// Add app running notification

        btn.setOnClickListener {
            builder.easy(contxt, "sauce", "moresauce", 22)

        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        val sauce="sauce"
        sauce.sauce()
    }
    fun String.sauce():String{
        return "blah"
    }



}
