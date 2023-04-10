package com.jokwanhee.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.databinding.FragmentDialogBinding

class CustomDialogFragment: DialogFragment() {
    private lateinit var binding: FragmentDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Custom)
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBack.setOnClickListener {
            dismiss()
        }
    }


    companion object{
        fun newInstance(): CustomDialogFragment {
            val args = Bundle()

            val fragment = CustomDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

}