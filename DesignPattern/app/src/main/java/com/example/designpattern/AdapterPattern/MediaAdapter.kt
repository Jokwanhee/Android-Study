package com.example.designpattern.AdapterPattern

class MediaAdapter(
    audioType: String
): MediaPlayer {
    private lateinit var advancedMediaPlayer: AdvancedMediaPlayer

    init {
        if (audioType == "vlc"){
            advancedMediaPlayer = VlcPlayer()
        } else if (audioType == "mp4"){
            advancedMediaPlayer = Mp4Player()
        }
    }

    override fun play(audioType: String, fileName: String) {
        if (audioType == "vlc"){
            advancedMediaPlayer.playVlc(fileName)
        } else if (audioType == "mp4"){
            advancedMediaPlayer.playMp4(fileName)
        }
    }
}