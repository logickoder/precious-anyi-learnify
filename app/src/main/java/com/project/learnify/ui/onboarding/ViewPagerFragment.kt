package com.project.learnify.ui.onboarding

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.project.learnify.R
import com.project.learnify.ui.onboarding.screens.FirstScreenFragment
import com.project.learnify.ui.onboarding.screens.SecondScreenFragment
import com.project.learnify.ui.onboarding.screens.ThirdScreenFragment


class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private lateinit var screens: List<Fragment>
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //We would pass our fragments for the onboarding screens here
        screens = listOf(
            FirstScreenFragment(::next),
            SecondScreenFragment(::next),
            ThirdScreenFragment(::next)
        )
        viewPager = view.findViewById<ViewPager2>(R.id.viewpager2).apply {
            adapter = ViewPageAdapter(
                screens,
                requireActivity().supportFragmentManager,
                lifecycle
            )
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun next() {
        if (viewPager.currentItem < screens.size)
            viewPager.currentItem = viewPager.currentItem + 1
        else finish()
    }

    private fun finish() {
        findNavController().navigate(R.id.action_viewPagerFragment_to_homeScreenFragment)
        requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE).edit().apply {
            putBoolean("Finished", true)
            apply()
        }
    }
}