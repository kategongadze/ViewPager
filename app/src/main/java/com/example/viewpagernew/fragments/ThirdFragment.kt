package com.example.viewpagernew.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagernew.R
import com.google.android.material.textfield.TextInputEditText

class ThirdFragment: Fragment (R.layout.fragment_third) {

    private lateinit var viewPager: ViewPager2
    private lateinit var buttonNext: Button
    private lateinit var editTextProfession: TextInputEditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        buttonNext.setOnClickListener {
            if (editTextProfession.text!!.isEmpty()) {
                Toast.makeText(activity, "Please fill form.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            saveData()
            viewPager.setCurrentItem(3, true)
        }

    }

    private fun init(view: View) {
        viewPager = requireActivity().findViewById(R.id.viewPager)
        buttonNext = view.findViewById(R.id.buttonNext)
        editTextProfession = view.findViewById(R.id.editTextProfession)
    }

    private fun saveData() {
        sharedPreferences = requireActivity().getSharedPreferences("Information", MODE_PRIVATE)

        var profession = editTextProfession.text.toString()

        sharedPreferences.edit()
            .putString("profession", profession)
            .apply()
    }

}