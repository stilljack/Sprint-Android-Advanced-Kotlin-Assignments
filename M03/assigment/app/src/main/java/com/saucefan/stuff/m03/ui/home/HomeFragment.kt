package com.saucefan.stuff.m03.ui.home

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saucefan.stuff.m03.ui.model.Model.allTheStuff
import com.saucefan.stuff.m03.ui.model.Model.rock
import com.saucefan.stuff.m03.toasty
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.saucefan.stuff.m03.ui.model.Model
import com.saucefan.stuff.m03.ui.model.Model.disco
import com.saucefan.stuff.m03.ui.model.Model.randomList
import com.saucefan.stuff.m03.ui.model.MusicModel
import com.saucefan.stuff.m03.R


class HomeFragment : Fragment() {
val contxt by lazy {
    context as Context
}
    val homeViewModel:HomeViewModel by viewModels { LiveDataVMFactory }
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ReAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            //ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        recyclerView =root.findViewById(R.id.recycle)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })



        setHasOptionsMenu(true)

        return root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(com.saucefan.stuff.m03.R.id.all).isVisible = true
        super.onPrepareOptionsMenu(menu)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Do something that differs the Activity's menu here

        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
 /*   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
     when (item.itemId) {

            R.id.rock -> {contxt.toasty("rock")
                fillAdapter(rock)
                return true}
            R.id.whatever ->{ contxt.toasty("whatever")
                allTheStuff.addAll(Model.whatever)
                return true}
            R.id.disco ->{contxt.toasty("disco")
                allTheStuff.addAll(disco)
                return true }
            R.id.all->{contxt.toasty("all")
                homeViewModel.switchList(allTheStuff)
                return true}
            R.id.random -> {
                contxt.toasty("random")
                homeViewModel.switchList(randomList().shuffled() as MutableList<MusicModel>)
            }
            else ->   return super.onContextItemSelected(item)

 }
     return super.onContextItemSelected(item)
 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        rock
        allTheStuff.set(0,rock[0])
        viewAdapter = ReAdapter()
        fillAdapter(allTheStuff)
        recyclerView.apply {

            homeViewModel.setReView(recyclerView)
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }

    }
    override fun onStart() {
        super.onStart()

    }

    private fun fillAdapter(mutlist:MutableList<MusicModel>) {
        val oldItems = viewAdapter.myDataset
        viewAdapter.myDataset= mutlist
        viewAdapter.notifyDataSetChanged()
    }


}