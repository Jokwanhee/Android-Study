package com.jokwanhee.fragment.createFragment.savedInstanceState

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivitySaveInstanceBinding

class SaveInstance : BaseActivity<ActivitySaveInstanceBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_save_instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("로그", "SaveInstance onCreate() : savedInstanceState : $savedInstanceState")
        clickEvent(savedInstanceState)
    }

    override fun initView() {
    }

    override fun initEvent() {

    }

    fun clickEvent(bundle: Bundle?){
        binding.buttonSaveFragment.setOnClickListener {
            // null 처리를 해주는 이유는 앱이 강제 종료되거나 가로세로모드로 변환될 때 savedInstanceState 은 다음 화면 호출 시 null 값이 아니다.
            // 그렇기 때문에 null 체크를 해준다면 매번 가로 세로모드를 변경될 때 마다 프래그먼트가 호출되지 않을 수 있다.
            if (bundle == null){
                val bundle = bundleOf("some_int" to 0)
                supportFragmentManager.commit {
                    setReorderingAllowed(true) // 애니메이션 전환이 올바르게 작동하도록 트랜잭션과 관련된 프래그먼트의 상태 변경을 최적화
                    replace<SaveInstanceFragment>(R.id.fragment_container_view_save, args=bundle, tag = "tag_saveInstance")
//                    replace<SaveInstanceFragment>(R.id.fragment_container, args=bundle)
                    addToBackStack("name")
                }
            } else {
            }
        }
    }
}