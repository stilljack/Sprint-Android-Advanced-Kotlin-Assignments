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
import com.saucefan.stuff.m03.R
import com.saucefan.stuff.m03.toasty
import com.saucefan.stuff.m03.ui.model.DataSourceLocal
import com.saucefan.stuff.m03.ui.model.Model
import com.saucefan.stuff.m03.ui.model.Model.disco
import com.saucefan.stuff.m03.ui.model.Model.rock
import com.saucefan.stuff.m03.ui.model.Model.whatever
import com.saucefan.stuff.m03.ui.model.MusicModel
import kotlinx.android.synthetic.main.cardview_list.*


class HomeFragment : Fragment() {
val contxt by lazy {
    context as Context
}
    private lateinit var homeViewModel:HomeViewModel
    private lateinit var  datasource:DataSourceLocal
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ReAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       // var homeViewModel:HomeViewModel = HomeViewModel()
          homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        recyclerView =root.findViewById(R.id.recycle)

        homeViewModel.toBeObserved().observe(this, Observer {
            fillAdapter(it)
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
                homeViewModel.allTheStuff.value?.addAll(Model.rock)
                return true}
            R.id.whatever ->{ contxt.toasty("whatever")
                homeViewModel.allTheStuff.value?.addAll(Model.whatever)
                return true}
            R.id.disco ->{contxt.toasty("disco")
                homeViewModel.allTheStuff.value?.addAll(disco)
                return true }
            R.id.all->{contxt.toasty("all")
              //  homeViewModel.switchList(homeViewModel.allTheStuff.value as MutableList<MusicModel>)
                return true}
            R.id.random -> {
                contxt.toasty("random")
                homeViewModel.randomList()
              //  homeViewModel.switchList(homeViewModel.randomList().shuffled() as MutableList<MusicModel>)
            }
            else ->   return super.onContextItemSelected(item)

 }
     return super.onContextItemSelected(item)
 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        rock
        homeViewModel.allTheStuff.value?.set(0,rock[0])
        viewAdapter = ReAdapter()
        fillAdapter(homeViewModel.allTheStuff.value as MutableList<MusicModel>)
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