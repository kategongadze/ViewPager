package com.example.viewpagernew

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagernew.adapter.ViewPagerFragmentAdapter
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerIndicator: CircleIndicator3

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        viewPagerIndicator = findViewById(R.id.viewPagerIndicator)

        viewPager.adapter = ViewPagerFragmentAdapter(this)
        viewPagerIndicator.setViewPager(viewPager)

    }
}