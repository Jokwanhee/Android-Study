package com.jokwanhee.fragment.fragment.factory

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.jokwanhee.fragment.fragment.factory.view.OneFragment
import com.jokwanhee.fragment.fragment.factory.view.ThreeFragment
import com.jokwanhee.fragment.fragment.factory.view.TwoFragment


/*
* AndroidX 부터는 instantiate()는 deprecated 되었고 FragmentFactory의 instantiate를 사용해 구현하라고 나와있다.
*
* 위 방법을 사용하는 이유는 기존에는 프래그먼트에 빈 생성자가 없다면 구성변경 및 앱의 프로세스 재생성과
* 같은 특정 상황에서 시스템은 프래그먼트를 초기화 하지 못했다. 이 점을 해결하기 위해 FragmentFactory를 사용하게 되었고
* Fragment에 필요한 인수 및 종속성을 제고하여 시스템이 Fragment를 더욱 잘 초기화하는데 도움을 준다.
* */

// 참고자료 : https://imwj.notion.site/FragmentFactory-8f3ad6874e9d43eba0af054b72b5a738

// koin 사용하여 FragmentFactory 좀 더 쉽게 사용하기
// https://insert-koin.io/docs/reference/koin-android/fragment-factory/
class FragmentFactoryImpl(private val age: Int): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className){
            OneFragment::class.java.name -> {
                OneFragment()
            }
            TwoFragment::class.java.name -> {
                TwoFragment().apply {
                    arguments = Bundle().apply {
                        putBundle("bundle_two", bundleOf("bundle_two" to age))
                    }
                }
            }
            ThreeFragment::class.java.name -> {
                ThreeFragment().apply {
                    arguments = Bundle().apply {
                        putBundle("bundle_three", bundleOf("bundle_three" to age))
                    }
                }
            }
            else -> return super.instantiate(classLoader, className)
        }
    }
}