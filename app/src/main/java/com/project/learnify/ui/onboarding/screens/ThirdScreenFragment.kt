package com.project.learnify.ui.onboarding.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.project.learnify.R

class ThirdScreenFragment(val onNext: () -> Unit) : Fragment(R.layout.fragment_third_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.start).setOnClickListener {
            onNext()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}