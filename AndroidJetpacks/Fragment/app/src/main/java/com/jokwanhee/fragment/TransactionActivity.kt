package com.jokwanhee.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.jokwanhee.fragment.databinding.ActivityTransactionBinding
import com.jokwanhee.fragment.fragmentTransaction.AddFragmentOne
import com.jokwanhee.fragment.fragmentTransaction.AddFragmentTwo
import com.jokwanhee.fragment.fragmentTransaction.CommitFragment

class TransactionActivity : AppCompatActivity() {
    private val commitFragment by lazy {
        CommitFragment.newInstance()
    }
    private val addFragmentOne by lazy {
        AddFragmentOne.newInstance()
    }
    private val addFragmentTwo by lazy {
        AddFragmentTwo.newInstance()
    }

    private lateinit var binding: ActivityTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCommitFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_containter_view, commitFragment)
                .commitNow()
        }


        binding.buttonAddFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_containter_view, addFragmentOne, "oneFragment")
                .commit()
        }

        binding.buttonAddFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_containter_view, addFragmentTwo, "twoFragment")
                .addToBackStack(null)
                .commit()
        }

        binding.buttonFindFragments.setOnClickListener {
            Log.d("로그", "${supportFragmentManager.fragments}")
        }
        binding.buttonRemoveFragment.setOnClickListener {
            val oneFragment = supportFragmentManager.findFragmentByTag("oneFragment")

            if (oneFragment != null){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_containter_view, oneFragment)
                    .commit()
            } else {
                Log.d("로그", "oneFragment no exist")
            }

        }


    }
}