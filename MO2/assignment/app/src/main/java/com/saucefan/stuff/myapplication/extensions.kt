package com.saucefan.stuff.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.content.Context.BIND_IMPORTANT
import android.content.Context.NOTIFICATION_SERVICE
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Build
import android.provider.Settings.Global.getString
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import javax.sql.DataSource


const val NOTIF_ID =0
lateinit var descriptionText:String
//lateinit var importance:String

fun notificationChannelInitialize(context: Context){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel
        val name = context.getString(R.string.channelName)
        descriptionText = context.getString(R.string.channelDescription)
        //importance = getString(NotificationManager.IMPORTANCE_DEFAULT)
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