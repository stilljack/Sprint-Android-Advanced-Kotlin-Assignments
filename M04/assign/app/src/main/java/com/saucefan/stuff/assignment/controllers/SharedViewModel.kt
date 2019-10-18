package com.saucefan.stuff.assignment.controllers

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import java.nio.channels.Selector
import java.util.*
import java.util.Observer

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<String>()

    fun select(string:String) {
        selected.value = string
    }


        private val liveData = MutableLiveData<String>()

        init {
            liveData.value = Date().toString()
        }

        fun getLiveData(): LiveData<String> {
            return liveData
        }

}
object LiveDataVMFactory : ViewModelProvider.Factory {

  //  private val dataSource = DefaultDataSource(Dispatchers.IO)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return SharedViewModel() as T
    }
}

/*
class MasterFragment : Fragment() {

    private lateinit var itemSelector: Selector

    private lateinit var model: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemSelector.setOnClickListener { item ->
            // Update the UI
        }
    }
}

class DetailFragment : Fragment() {

    private lateinit var model: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        model.selected.observe(this, Observer<ClipData.Item> { item ->
            // Update the UI
        })
    }
}*/