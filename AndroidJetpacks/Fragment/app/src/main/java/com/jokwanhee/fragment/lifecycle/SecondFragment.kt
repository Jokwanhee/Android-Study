package com.jokwanhee.fragment.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jokwanhee.fragment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentLifeCycle", "SecondFragment - onCreate()")
        Log.d("FragmentLifeCycle", "SecondFragment - onCreate() STATED : ${lifecycle.currentState}")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentLifeCycle", "SecondFragment - onCreateView()")
        Log.d("FragmentLifeCycle", "SecondFragment - onCreateView() STATED : ${lifecycle.currentState}")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("FragmentLifeCycle", "SecondFragment - onViewCreated()")
        Log.d("FragmentLifeCycle", "SecondFragment - onViewCreated() STATED : ${lifecycle.currentState}")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.d("FragmentLifeCycle", "SecondFragment - onStart()")
        Log.d("FragmentLifeCycle", "SecondFragment - onStart() STATED : ${lifecycle.currentState}")

        super.onStart()
    }

    override fun onResume() {
        Log.d("FragmentLifeCycle", "SecondFragment - onResume()")
        Log.d("FragmentLifeCycle", "SecondFragment - onResume() STATED : ${lifecycle.currentState}")

        super.onResume()
    }

    override fun onPause() {
        Log.d("FragmentLifeCycle", "SecondFragment - onPause()")
        Log.d("FragmentLifeCycle", "SecondFragment - onPause() STATED : ${lifecycle.currentState}")

        super.onPause()
    }

    override fun onStop() {
        Log.d("FragmentLifeCycle", "SecondFragment - onStop()")
        Log.d("FragmentLifeCycle", "SecondFragment - onStop() STATED : ${lifecycle.currentState}")

        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("FragmentLifeCycle", "SecondFragment - onDestroyView()")
        Log.d("FragmentLifeCycle", "SecondFragment - onDestroyView() STATED : ${lifecycle.currentState}")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("FragmentLifeCycle", "SecondFragment - onDestroy()")
        Log.d("FragmentLifeCycle", "SecondFragment - onDestroy() STATED : ${lifecycle.currentState}")

        super.onDestroy()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}