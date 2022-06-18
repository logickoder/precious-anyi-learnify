package com.project.learnify.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.learnify.R
import kotlinx.coroutines.delay


class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenCreated {
            delay(4000)
            findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
        }
        super.onCreate(savedInstanceState)
    }
}