package com.project.learnify

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.project.learnify.databinding.FragmentCourseDetailsBinding

class CourseDetailsFragment : Fragment(R.layout.fragment_course_details) {
    private var _binding: FragmentCourseDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCourseDetailsBinding.bind(view).also {
            it.scroll
            it.courseTitle.text = arguments?.getString(Course) ?: ""
            it.courseDetails.text = arguments?.getString(Details) ?: ""
            arguments?.getInt(ImageView)?.let { image ->
                it.imageView3.setImageResource(image)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val Course = "course"
        const val Details = "details"
        const val ImageView = "image"
    }
}