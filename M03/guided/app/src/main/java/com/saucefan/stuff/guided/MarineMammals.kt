package com.saucefan.stuff.guided

sealed class MarineMammals (val name:String) {
    class whale(name: String) : MarineMammals(name)
    class porpoise(name: String) : MarineMammals(name)
    class Dolphin(name: String) : MarineMammals(name)
}