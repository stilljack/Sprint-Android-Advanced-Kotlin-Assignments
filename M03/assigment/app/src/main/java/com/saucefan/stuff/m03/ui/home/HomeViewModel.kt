package com.saucefan.stuff.m03.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.saucefan.stuff.m03.ui.model.MusicModel
import kotlinx.coroutines.Dispatchers
import javax.sql.DataSource

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
        val newAdapter=ReAdapter()
        newAdapter.myDataset=list
        recyclerView.swapAdapter(newAdapter, false)
    }
}
object LiveDataVMFactory : ViewModelProvider.Factory {

    private val dataSource = com.saucefan.stuff.m03.ui.model.DataSourceLocal("s")

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return HomeViewModel() as T
    }
}