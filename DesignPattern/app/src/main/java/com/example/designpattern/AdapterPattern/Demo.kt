package com.example.designpattern.AdapterPattern

class Demo {
    fun main(){
        val audioPlayer = AudioPlayer()

        // AudioPlayer 클래스에서 관리하는 type
        audioPlayer.play("mp3", "겨울왕국.mp3")

        // adapter 지원을 받는 type
        audioPlayer.play("mp4", "모아나.mp4")
        audioPlayer.play("vlc", "인어공주.vlc")

        // 지원하지 않은 type
        audioPlayer.play("avi", "백설공주.avi")
    }
}

fun main() {
    val demo = Demo()
    demo.main()
}