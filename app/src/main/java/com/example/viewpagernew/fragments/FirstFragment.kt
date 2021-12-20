package com.example.viewpagernew.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagernew.R
import com.google.android.material.textfield.TextInputEditText

class FirstFragment: Fragment (R.layout.fragment_first) {
    private lateinit var viewPager: ViewPager2
    private lateinit var buttonNext: Button
    private lateinit var editTextName: TextInputEditText
    private lateinit var editTextSurname: TextInputEditText

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        buttonNext.setOnClickListener {
            if (editTextName.text!!.isEmpty() || editTextSurname.text!!.isEmpty()) {
                Toast.makeText(activity, "Please fill form.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            saveData()
            viewPager.setCurrentItem(1, true)
        }

    }

    private fun init(view: View) {
        viewPager = requireActivity().findViewById(R.id.viewPager)
        buttonNext = view.findViewById(R.id.buttonNext)
        editTextName = view.findViewById(R.id.editTextName)
        editTextSurname = view.findViewById(R.id.editTextSurname)
    }

    private fun saveData() {
        sharedPreferences = requireActivity().getSharedPreferences("Information", Context.MODE_PRIVATE)

        val name = editTextName.text.toString()
        val surname = editTextSurname.text.toString()

        sharedPreferences.edit()
            .putString("name", name)
            .putString("surname", surname)
            .apply()
    }

}