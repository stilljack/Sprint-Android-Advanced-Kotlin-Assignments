package com.saucefan.stuff.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.BIND_IMPORTANT
import android.content.Context.NOTIFICATION_SERVICE
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Build
import android.provider.Settings.Global.getString
import androidx.core.app.NotificationCompat


const val NOTIF_ID =0
lateinit var descriptionText:String
lateinit var importance:String

fun notificationChannelInitialize(context: Context){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel
        val name = context.getString(R.string.channelName)
        descriptionText = context.getString(R.string.channelDescription)
        importance = context.getString(NotificationManager.IMPORTANCE_DEFAULT)
        val mChannel = NotificationChannel(context.getString(R.string.channelID), name, NotificationManager.IMPORTANCE_LOW)
        mChannel.description = context.getString(R.string.channelDescription)
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }
}


fun NotificationCompat.Builder.easy(context: Context, title:String, content:String, notificationID:Int) {

    val nm =context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

    val res = context.getResources()
    val builder = NotificationCompat.Builder(context)

    builder
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher_background))
        .setTicker(res.getString(R.string.ticker))
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setContentTitle(title)
        .setContentText(content)
    val n = builder.build()

    nm.notify(notificationID, n)
}


/*(this, CHANNEL_ID)
*/