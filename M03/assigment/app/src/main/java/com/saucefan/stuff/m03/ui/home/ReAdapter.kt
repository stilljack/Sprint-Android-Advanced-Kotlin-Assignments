package com.saucefan.stuff.m03.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.saucefan.stuff.m03.*
import com.saucefan.stuff.m03.ui.AutoUpdatableAdapter
import kotlinx.android.synthetic.main.cardview_list.view.*
import kotlin.properties.Delegates

class ReAdapter() : RecyclerView.Adapter<ReAdapter.MyViewHolder>(),
    AutoUpdatableAdapter {


    var myDataset: List<MusicModel> by Delegates.observable(emptyList()) {
            prop, old, new ->
        autoNotify(old, new) { o, n -> o.name != n.name }
    }
    class MyViewHolder(val cv: CardView) : RecyclerView.ViewHolder(cv)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ReAdapter.MyViewHolder {
        // create a new view
        val cv = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_list, parent, false)  as CardView
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(cv)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val current =myDataset[position]
        holder.cv.artist.text = current.artist
        holder.cv.song.text = current.name
        holder.cv.whatever.text = when (current) {
            is Rock -> "rockReA"
                is Disco ->"discoReA"
                    is Whatever ->"whateverReA"
        }

    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size




}