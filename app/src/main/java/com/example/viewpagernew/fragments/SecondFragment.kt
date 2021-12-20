package com.example.viewpagernew.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagernew.R
import com.google.android.material.textfield.TextInputEditText

class SecondFragment: Fragment (R.layout.fragment_second) {

    private lateinit var viewPager: ViewPager2
    private lateinit var buttonNext: Button
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        buttonNext.setOnClickListener {
            if (editTextEmail.text!!.isEmpty()) {
                Toast.makeText(activity, "Please fill form.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            saveData()
            viewPager.setCurrentItem(2, true)
        }

    }

    private fun init(view: View) {
        viewPager = requireActivity().findViewById(R.id.viewPager)
        buttonNext = view.findViewById(R.id.buttonNext)
        editTextEmail = view.findViewById(R.id.editTextEmail)
    }

    private fun saveData() {
        sharedPreferences = requireActivity().getSharedPreferences("Information", MODE_PRIVATE)

        val email = editTextEmail.text.toString()

        sharedPreferences.edit()
            .putString("email", email)
            .apply()
    }

}