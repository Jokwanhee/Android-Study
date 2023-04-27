package com.example.designpattern.AdapterPattern

import com.example.designpattern.AdapterPattern.Interface.AdvancedMediaPlayer

class Mp4Player: AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        // do nothing
    }

    override fun playMp4(fileName: String) {
        println("Playing mp4 file. Name: $fileName")
    }
}