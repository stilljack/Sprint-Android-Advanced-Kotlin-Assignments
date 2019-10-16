package com.saucefan.stuff.m03.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.saucefan.stuff.m03.MusicModel

class HomeViewModel : ViewModel() {
lateinit var recyclerView: RecyclerView


    private val _text = MutableLiveData<String>().apply {
        value = "et"
    }
    val text: LiveData<String> = _text

    fun setReView(reView: RecyclerView) {
        recyclerView=reView
    }
    fun switchList(list:MutableList<MusicModel>) {
        val newAdapter=ReAdapter(list)
        recyclerView.swapAdapter(newAdapter, false)
    }
}