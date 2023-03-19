package com.jokwanhee.fragment.fragmentTransaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jokwanhee.fragment.R

class CommitFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("로그", "CommitFragment onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("로그", "CommitFragment onCreateView()")

        return inflater.inflate(R.layout.fragment_commit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("로그", "CommitFragment onViewCreated()")

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): CommitFragment{

            return CommitFragment()
        }
    }

    override fun onStart() {
        Log.d("로그", "CommitFragment onStart()")

        super.onStart()
    }

    override fun onResume() {
        Log.d("로그", "CommitFragment onResume()")

        super.onResume()
    }

    override fun onPause() {
        Log.d("로그", "CommitFragment onPause()")

        super.onPause()
    }

    override fun onStop() {
        Log.d("로그", "CommitFragment onStop()")

        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("로그", "CommitFragment onDestroyView()")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("로그", "CommitFragment onDestroy()")

        super.onDestroy()
    }
}