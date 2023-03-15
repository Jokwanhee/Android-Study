package com.jokwanhee.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.jokwanhee.fragment.fragment.BasicFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("로그", "MainActivity onCreate() : savedInstanceState : $savedInstanceState")
        // null 처리를 해주는 이유는 앱이 강제 종료되거나 가로세로모드로 변환될 때 savedInstanceState 은 다음 화면 호출 시 null 값이 아니다.
        // 그렇기 때문에 null 체크를 해준다면 매번 가로 세로모드를 변경될 때 마다 프래그먼트가 호출되지 않을 수 있다.
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<BasicFragment>(R.id.fragment_container)
            }
        } else {
        }
    }
}