package com.jokwanhee.fragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.jokwanhee.fragment.fragment.BasicFragment
import com.jokwanhee.fragment.fragment.InstanceFragment
import com.jokwanhee.fragment.fragment.SaveInstanceFragment
import com.jokwanhee.fragment.fragment.factory.FragmentFactoryImpl
import com.jokwanhee.fragment.fragment.factory.view.OneFragment
import com.jokwanhee.fragment.fragment.factory.view.ThreeFragment
import com.jokwanhee.fragment.fragment.factory.view.TwoFragment

class MainActivity : AppCompatActivity() {
    private val basicFragment by lazy {
        BasicFragment()
    }

    private val instanceFragment by lazy {
        InstanceFragment.newInstance()
    }

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val basicButton = findViewById<Button>(R.id.button_basic_fragment)
        val savedInstanceStateButton = findViewById<Button>(R.id.button_savedInstanceState_fragment)
        val instanceButton = findViewById<Button>(R.id.button_instance_fragment)

        supportFragmentManager.fragmentFactory = FragmentFactoryImpl(100)

        Log.e("로그", "MainActivity onCreate() : savedInstanceState : $savedInstanceState")

        basicButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putBundle("basic_bundle", bundleOf("basic_int" to 1))
            basicFragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, basicFragment)
                .commit()
        }

        savedInstanceStateButton.setOnClickListener {
            // null 처리를 해주는 이유는 앱이 강제 종료되거나 가로세로모드로 변환될 때 savedInstanceState 은 다음 화면 호출 시 null 값이 아니다.
            // 그렇기 때문에 null 체크를 해준다면 매번 가로 세로모드를 변경될 때 마다 프래그먼트가 호출되지 않을 수 있다.
            if (savedInstanceState == null){
                val bundle = bundleOf("some_int" to 0)
                supportFragmentManager.commit {
                    setReorderingAllowed(true) // 애니메이션 전환이 올바르게 작동하도록 트랜잭션과 관련된 프래그먼트의 상태 변경을 최적화
                    replace<SaveInstanceFragment>(R.id.fragment_container, args=bundle, tag = "tag_saveInstance")
//                    replace<SaveInstanceFragment>(R.id.fragment_container, args=bundle)
                    addToBackStack("name")
                }
            } else {
            }
        }


        instanceButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, instanceFragment)
                .commit()
        }

        initFactory()

    }

    fun initFactory(){
        val factoryOneButton = findViewById<Button>(R.id.button_factory_fragment_one)
        val factoryTwoButton = findViewById<Button>(R.id.button_factory_fragment_two)
        val factoryThreeButton = findViewById<Button>(R.id.button_factory_fragment_three)

        factoryOneButton.setOnClickListener {
            fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, OneFragment::class.java.name)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commitNow()
        }
        factoryTwoButton.setOnClickListener {
            fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, TwoFragment::class.java.name)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commitNow()
        }
        factoryThreeButton.setOnClickListener {
            fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, ThreeFragment::class.java.name)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commitNow()
        }
    }


}