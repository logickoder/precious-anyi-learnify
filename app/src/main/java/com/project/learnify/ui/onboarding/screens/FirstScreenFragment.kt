package com.project.learnify.ui.onboarding.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.project.learnify.R


class FirstScreenFragment(val onNext: () -> Unit) : Fragment(R.layout.fragment_first_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.next).setOnClickListener {
            onNext()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}