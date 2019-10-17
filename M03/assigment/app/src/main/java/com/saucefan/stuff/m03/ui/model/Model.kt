package com.saucefan.stuff.m03.ui.model

import kotlin.random.Random

sealed class MusicModel (val name:String, val artist:String)
class Rock(name: String,artist:String)     : MusicModel(name,artist)
class Disco(name: String,artist:String)    : MusicModel(name,artist)
class Whatever(name: String,artist:String) : MusicModel(name,artist)



object Model {
    val rock = mutableListOf<MusicModel>(
        Rock("r s 1", "r a 1"),
        Rock("r s 2", "r a 2"),
        Rock("r s 3", "r a 3")
    )
    val disco = mutableListOf<MusicModel>(
        Disco("d s 1", "d a 1"),
        Disco("d s 2", "d a 2"),
        Disco("d s 3", "d a 3")
    )
    val whatever = mutableListOf<MusicModel>(
        Whatever("w s 1", "w a 1"),
        Whatever("w s 2", "w a 2"),
        Whatever("w s 3", "w a 3")
    )

  var allTheStuff = mutableListOf<MusicModel>()

    var someStuff = mutableListOf<MusicModel>()
    set(value) {
        when (value) {
            rock -> field.addAll(rock)
            disco -> field.addAll(disco)
            whatever -> field.addAll(whatever)
        else -> field= mutableListOf<MusicModel>()
        }

    }
    init {

        allTheStuff   .addAll(rock)
        allTheStuff  .addAll(disco)
        allTheStuff  .addAll(whatever)

    }

    fun randomList():MutableList<MusicModel>{
        val mutlist= mutableListOf<MusicModel>()
        for (i in 0 until allTheStuff.size) {
            if (Random.nextInt(10)<=5){
                mutlist.add(allTheStuff[i])
            }
        }
        return mutlist
    }
}

/*
class listOfStuff {
    var allTheStuffObservable: MutableList<MusicModel> by observable(allTheStuff) { _, oldValue, newValue ->
        onItemsChanged?.invoke(oldValue, newValue)
    }
    // Adapter



val list = ListOfStuff()
book.onItemsChanged = { oldValue, newValue ->
    // do stuff
}*/
