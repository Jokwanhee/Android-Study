package com.example.designpattern.AdapterPattern

import com.example.designpattern.AdapterPattern.Adapter.MediaAdapter
import com.example.designpattern.AdapterPattern.Interface.MediaPlayer

class AudioPlayer: MediaPlayer {
    private lateinit var mediaAdapter: MediaAdapter

    override fun play(audioType: String, fileName: String) {
        // inbuilt support to play mp3 music files
        if (audioType == "mp3"){
            println("Playing mp3 file. Name : $fileName")
        }

        // mediaAdapter is providing support to play other file formats
        else if (audioType == "vlc" || audioType == "mp4"){
            mediaAdapter = MediaAdapter(audioType)
            mediaAdapter.play(audioType, fileName)
        }
        else {
            println("Invalid media. $audioType format not supported")
        }
    }
}