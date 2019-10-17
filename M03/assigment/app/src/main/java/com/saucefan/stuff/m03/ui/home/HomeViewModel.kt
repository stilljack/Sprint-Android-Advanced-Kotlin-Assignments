package com.saucefan.stuff.m03.ui.home

import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.RecyclerView
import com.saucefan.stuff.m03.ui.model.DataSourceLocal
import com.saucefan.stuff.m03.ui.model.Model
import com.saucefan.stuff.m03.ui.model.Model.disco
import com.saucefan.stuff.m03.ui.model.Model.rock
import com.saucefan.stuff.m03.ui.model.Model.whatever
import com.saucefan.stuff.m03.ui.model.MusicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class HomeViewModel(private val dataSource: DataSourceLocal) : ViewModel() {
    lateinit var recyclerView: RecyclerView

    var allTheStuff: LiveData<MutableList<MusicModel>> = toBeObserved()


    fun toBeObserved(): LiveData<MutableList<MusicModel>> = liveData {
        var counter = 0
        while (true) {
            counter++
            delay(2000)
            emit(
                when (Random.nextInt(10)) {
                    1 - 3 -> rock
                    3 - 7 -> disco
                    else -> whatever

                }
            )
        }

    }

    fun setReView(reView: RecyclerView) {
        recyclerView = reView
    }

    fun switchList(list: MutableList<MusicModel>) {
        val newAdapter = ReAdapter()
        newAdapter.myDataset = list
        recyclerView.swapAdapter(newAdapter, false)
    }


    fun randomList() {
        val mutlist = mutableListOf<MusicModel>()
        val element = allTheStuff.value
        for (i in 0 until element?.size as Int) {
            if (Random.nextInt(10) <= 5) {
                mutlist.add(element[i])
            }
            else{
                mutlist.removeAt(i)
            }
        }

    }

}

    object LiveDataVMFactory : ViewModelProvider.Factory {
        private val dataSource = DataSourceLocal(Dispatchers.IO)

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dataSource) as T
        }
    }
