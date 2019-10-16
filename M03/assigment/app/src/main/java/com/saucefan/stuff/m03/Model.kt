package com.saucefan.stuff.m03

sealed class MusicModel (val name:String, val artist:String)
class Rock(name: String,artist:String)     : MusicModel(name,artist)
class Disco(name: String,artist:String)    : MusicModel(name,artist)
class Whatever(name: String,artist:String) : MusicModel(name,artist)



object Model {
    val rock = mutableListOf<Rock>(
        Rock("r s 1", "r a 1"),
        Rock("r s 2", "r a 2"),
        Rock("r s 3", "r a 3")
    )
    val disco = mutableListOf<Disco>(
        Disco("d s 1", "d a 1"),
        Disco("d s 2", "d a 2"),
        Disco("d s 3", "d a 3")
    )
    val whatever = mutableListOf<Whatever>(
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

}