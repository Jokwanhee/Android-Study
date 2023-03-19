package com.jokwanhee.fragment.fragmentTransaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jokwanhee.fragment.R

class AddFragmentOne:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("로그", "AddFragmentOne onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("로그", "AddFragmentOne onCreateView()")

        return inflater.inflate(R.layout.fragment_add_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("로그", "AddFragmentOne onViewCreated()")

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): AddFragmentOne{
            return AddFragmentOne()
        }
    }

    override fun onStart() {
        Log.d("로그", "AddFragmentOne onStart()")

        super.onStart()
    }

    override fun onResume() {
        Log.d("로그", "AddFragmentOne onResume()")

        super.onResume()
    }

    override fun onPause() {
        Log.d("로그", "AddFragmentOne onPause()")

        super.onPause()
    }

    override fun onStop() {
        Log.d("로그", "AddFragmentOne onStop()")

        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("로그", "AddFragmentOne onDestroyView()")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("로그", "AddFragmentOne onDestroy()")

        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("로그", "AddFragmentOne onDetach()")

        super.onDetach()
    }
}