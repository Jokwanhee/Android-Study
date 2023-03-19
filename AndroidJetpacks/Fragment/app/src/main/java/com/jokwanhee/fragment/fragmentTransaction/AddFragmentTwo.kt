package com.jokwanhee.fragment.fragmentTransaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jokwanhee.fragment.R

class AddFragmentTwo:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("로그", "AddFragmentTwo onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("로그", "AddFragmentTwo onCreateView()")

        return inflater.inflate(R.layout.fragment_add_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("로그", "AddFragmentTwo onViewCreated()")

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): AddFragmentTwo{
            return AddFragmentTwo()
        }
    }

    override fun onStart() {
        Log.d("로그", "AddFragmentTwo onStart()")

        super.onStart()
    }

    override fun onResume() {
        Log.d("로그", "AddFragmentTwo onResume()")

        super.onResume()
    }

    override fun onPause() {
        Log.d("로그", "AddFragmentTwo onPause()")

        super.onPause()
    }

    override fun onStop() {
        Log.d("로그", "AddFragmentTwo onStop()")

        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("로그", "AddFragmentTwo onDestroyView()")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("로그", "AddFragmentTwo onDestroy()")

        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("로그", "AddFragmentTwo onDetach()")

        super.onDetach()
    }
}