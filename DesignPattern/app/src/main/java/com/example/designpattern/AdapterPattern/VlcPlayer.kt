package com.example.designpattern.AdapterPattern

import com.example.designpattern.AdapterPattern.Interface.AdvancedMediaPlayer

class VlcPlayer: AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Playing vlc file. Name + $fileName")
    }

    override fun playMp4(fileName: String) {
        // do nothing
    }
}