package com.project.learnify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.learnify.databinding.FragmentCourseDetailsBinding
import kotlin.properties.Delegates

class CourseDetailsFragment : Fragment() {
    private var _binding: FragmentCourseDetailsBinding? = null
    private val binding get() = _binding !!
    private lateinit var courseTitile: String
    private lateinit var courseDetails: String
    private  var image by Delegates.notNull<Int>()

    companion object {
        const val Course = "course"
        const val Details = "details"
        const val ImageView = "image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            courseTitile = it?.getString(Course).toString()
            courseDetails = it?.getString(Details).toString()
            if (it != null) {
                image = it.getInt(ImageView)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCourseDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.scroll
        binding.courseTitle.text  = courseTitile
        binding.courseDetails.text = courseDetails
        binding.imageView3.setImageResource(image)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}