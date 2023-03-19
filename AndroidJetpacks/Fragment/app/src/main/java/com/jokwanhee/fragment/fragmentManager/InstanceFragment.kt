package com.jokwanhee.fragment.fragmentManager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.jokwanhee.fragment.R

class InstanceFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /*
    * Fragment를 상속받을 땐 인자가 없는 기본 생성자를 반드시 포함해야 한다는 내용이다.
    * Fragment는 자기만의 라이프사이클을 가지고 있지만 액티비티 라이프사이클에 종속적이다.
    * 따라서 메모리가 부족하거나 화면회전, 디스플레이 변경 등의 다양한 이벤트로 액티비티가 재생성 될 때 프래그먼트도 재생성이 된다.
    *
    * 위에 같은 이유로 프래그먼트의 잦은 재생성이 일어난다.
    * 이를 해결하는 방법으로 newInstance()를 활용하는 것
    * */
    companion object {
        fun newInstance(): InstanceFragment {
            val fragment = InstanceFragment()
            val args = Bundle()
            args.putBundle("bundle_instance", bundleOf("bundle_instance" to 2))
            fragment.arguments = args

            return fragment
        }
    }
}