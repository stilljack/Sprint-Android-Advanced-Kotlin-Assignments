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
            return selected
        }

}
object LiveDataVMFactory : ViewModelProvider.Factory {

  //  private val dataSource = DefaultDataSource(Dispatchers.IO)
  val hashMapViewModel = HashMap<String, ViewModel>()
    fun addViewModel(key: String, viewModel: ViewModel){
        hashMapViewModel.put(key, viewModel)
    }
    fun getViewModel(key: String): ViewModel? {
        return hashMapViewModel[key]
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            val key = "SharedViewModel"
            if (hashMapViewModel.containsKey(key)) {
                return getViewModel(key) as T
            } else {
                addViewModel(key, SharedViewModel())
                return getViewModel(key) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
        /*     return SharedViewModel() as T

    }*/
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