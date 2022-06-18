package com.project.learnify

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.learnify.adapter.CourseAdapter
import com.project.learnify.databinding.FragmentHomeScreenBinding
import com.project.learnify.model.Courses

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeScreenBinding.bind(view)
        recyclerView = binding.recyclerview
        recyclerView.setHasFixedSize(true)
        //setting adapter and recyclerview layout
        courseAdapter = CourseAdapter(courseList)
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //inflate the layout
        inflater.inflate(R.menu.layout_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.change_layout)?.setIcon()
        super.onPrepareOptionsMenu(menu)
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        } else {
            recyclerView.layoutManager =
                GridLayoutManager(requireContext(), GridLayoutManager.VERTICAL)
        }
        recyclerView.adapter = courseAdapter
    }

    private fun MenuItem.setIcon() {
        icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid)
            else {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_staggered_grid)
            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.change_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                item.setIcon()
                true
            }
            R.id.contact_us -> {
                findNavController().navigate(
                    HomeScreenFragmentDirections.actionHomeScreenFragmentToContactFragment()
                )
                true
            }
            R.id.about_us -> {
                findNavController().navigate(
                    HomeScreenFragmentDirections.actionHomeScreenFragmentToAboutFragment()
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

private val courseList = listOf(
    Courses(
        R.drawable.course_image,
        "Android App Development Course For Beginners",
        " Welcome To The Complete Android Developer Course: Beginner To Advanced\n" +
                "⇉ Watch the promo video to see How You Can Begin Building And Developing Your Very Own Android Applications Today!\n" +
                "⇉ This Course is MASSIVE! You receive over 17+ hours of video content and 140+ lectures!\n" +
                "⇉ Join Over 275,000+ Students Who Have Enrolled In My Udemy Courses This Year!\n" +
                "⇉ 7,500+ Five Star Reviews on our courses prove Students Who Enrolling Are Getting Real Results!\n" +
                "Then this course is for you! Click \"Take This Course Now\" For Instant Life-Time Access!"
    ),
    Courses(
        R.drawable.android_user_interface,
        "Android User Interface",
        " courseList.add(Courses(R.drawable.course_image,\n" +
                "            \"Android App Development Course For Beginners\",\n" +
                "        \" Welcome To The Complete Android Developer Course: Beginner To Advanced\\n\" +\n" +
                "                \" Watch the promo video to see How You Can Begin Building And Developing Your Very Own Android Applications Today!\\n\" +\n" +
                "                \" This Course is MASSIVE! You receive over 17+ hours of video content and 140+ lectures!\\n\" +\n" +
                "                \" Join Over 275,000+ Students Who Have Enrolled In My Udemy Courses This Year!\\n\" +\n" +
                "                \" 7,500+ Five Star Reviews on our courses prove Students Who Enrolling Are Getting Real Results!\\n\" +\n" +
                "                \"Then this course is for you! Click \\\"Take This Course Now\\\" For Instant Life-Time Access!\"))"
    ),
    Courses(
        R.drawable.unit_testing,
        "Android Unit Testing Development",
        "Unit testing is widely considered one of the most important skills for senior Android developers to have. It's a great investment into medium- and long-term professional career growth.\n" +
                "\n" +
                "If bugs slip into your Android application, it can be very challenging to locate and fix them. Furthermore, even after you fix the bugs, it can take days or even weeks until all your users update the app to actually receive these fixes. That's a tough reality of professional Android developer's job. Fortunately, you can greatly reduce the number of bugs in your applications by unit testing your code!\n" +
                "\n" +
                "To make your applications unit testable, you'll need to write decoupled code that follows best design principles. This automatically guarantees easier long-term maintenance. In addition, unit testing makes developing Android applications easier and spares a lot of time when done right. "
    )
)