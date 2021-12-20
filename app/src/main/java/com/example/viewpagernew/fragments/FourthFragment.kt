package com.example.viewpagernew.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpagernew.R

class FourthFragment: Fragment(R.layout.fragment_fourth) {

    private lateinit var textViewName: TextView
    private lateinit var textViewSurname: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var textViewProfession: TextView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("Information", MODE_PRIVATE)

        init(view)

        textViewName.text = sharedPreferences.getString("name", "")
        textViewSurname.text = sharedPreferences.getString("surname", "")
        textViewEmail.text = sharedPreferences.getString("email", "")
        textViewProfession.text = sharedPreferences.getString("profession", "")

    }

    private fun init(view: View) {
        textViewName = view.findViewById(R.id.textViewName)
        textViewSurname = view.findViewById(R.id.textViewSurname)
        textViewEmail = view.findViewById(R.id.textViewEmail)
        textViewProfession = view.findViewById(R.id.textViewProfession)

    }

}