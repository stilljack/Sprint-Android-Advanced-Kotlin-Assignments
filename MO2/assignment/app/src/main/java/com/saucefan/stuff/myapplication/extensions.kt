package com.saucefan.stuff.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener


const val NOTIF_ID =22
lateinit var descriptionText:String
//lateinit var importance:String

fun notificationChannelInitialize(context: Context){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel
        val name = context.getString(R.string.channelName)
        descriptionText = context.getString(R.string.channelDescription)
        //importance =
        val mChannel = NotificationChannel(context.getString(R.string.channelID), name, NotificationManager.IMPORTANCE_LOW)
        mChannel.description = context.getString(R.string.channelDescription)
        mChannel.importance=IMPORTANCE_DEFAULT
        mChannel.name=name

        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }
}


fun NotificationCompat.Builder.easy(context: Context, title:String, content:String, notificationID:Int) {

    val nm =context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

    val res = context.getResources()
   // val builder = NotificationCompat.Builder(context)
    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    val builder = NotificationCompat.Builder(context, context.getString(R.string.channelID))
        .setSmallIcon(R.drawable.ic_launcher_background)
       // .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher_background))
        .setTicker(res.getString(R.string.ticker))
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setContentTitle(title)
        .setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_SOUND)
        .setContentText(content)
        .setContentIntent(pendingIntent)
        .setContentInfo("Info")


        nm.notify(NOTIF_ID, builder.build())
    }




fun ImageView.loadurl(context:Context,url: String,id:ImageView) {

    Glide.with(context)
        .load(url)
        .onSuccessOrFailure({
        Toast.makeText(this.context, "It worked", Toast.LENGTH_LONG).show()
    }, onFailure = {
        Toast.makeText(this.context, "It didn't work", Toast.LENGTH_LONG).show()
    })
        .into(id)
}

fun RequestBuilder<Drawable>.onSuccessOrFailure(
    onSuccess: () -> Unit,
    onFailure: () -> Unit
): RequestBuilder<Drawable> {
    return this.addListener(object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: com.bumptech.glide.request.target.Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            onFailure.invoke()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: com.bumptech.glide.request.target.Target<Drawable>?,
            dataSource: com.bumptech.glide.load.DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            onSuccess.invoke()
            return false
        }
    })

}


/*fun Glide.with( e: GlideException?,
                        model: Any?,
                        target: Drawable?,
                        isFirstResource: Boolean):Boolean{

    return false*/

/*(this, CHANNEL_ID)
*/

/////
/*
private fun loadurl(url:String){
        Glide.with(this)
            .load(url)
            .listener(object : RequestListener<Drawable> {
   override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoaded = false
                    return false
                }
​
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoaded = true
                    return false
                }
            })
            .into(this)
    }
 */