package com.jokwanhee.fragment.fragmentstate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.databinding.FragmentStateBinding

class StateFragment: Fragment() {
    private lateinit var binding: FragmentStateBinding
    private var editStr = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("로그", "onCreate ${savedInstanceState?.getString(EDIT_STRING)}")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("로그", "onCreateView ")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_state, container, false)
        binding.editTextInputStateText.addTextChangedListener {
            editStr = it.toString()
            binding.textViewStateTitle.setText(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EDIT_STRING, "1234")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("로그", "onViewStateRestored ")
        Log.d("로그", "onViewStateRestored ${savedInstanceState?.getString(EDIT_STRING).toString()}")
        editStr = savedInstanceState?.getString(EDIT_STRING).toString() ?: ""
        binding.textViewStateTitle.text = editStr
        binding.editTextInputStateText.setText(editStr)
    }


    companion object{
        fun newInstance(): StateFragment {
            val args = Bundle()

            val fragment = StateFragment()
            fragment.arguments = args
            return fragment
        }

        const val EDIT_STRING = "EDIT_STRING"
    }

}