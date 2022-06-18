package com.project.learnify

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.learnify.adapter.CourseAdapter
import com.project.learnify.databinding.FragmentHomeScreenBinding
import com.project.learnify.model.Courses


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding !!
    private lateinit var courseList: ArrayList<Courses>
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var recyclerView: RecyclerView
    private var isGridLayoutManager = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
       /* chooseLayout()*/

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeScreenBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerview
        recyclerView.setHasFixedSize(true)

        courseList = ArrayList()

        //adding course image, course title and course details
        courseList.add(Courses(R.drawable.course_image,
            "Android App Development Course For Beginners",
        " Welcome To The Complete Android Developer Course: Beginner To Advanced\n" +
                "⇉ Watch the promo video to see How You Can Begin Building And Developing Your Very Own Android Applications Today!\n" +
                "⇉ This Course is MASSIVE! You receive over 17+ hours of video content and 140+ lectures!\n" +
                "⇉ Join Over 275,000+ Students Who Have Enrolled In My Udemy Courses This Year!\n" +
                "⇉ 7,500+ Five Star Reviews on our courses prove Students Who Enrolling Are Getting Real Results!\n" +
                "Then this course is for you! Click \"Take This Course Now\" For Instant Life-Time Access!"))
        courseList.add(Courses(R.drawable.android_user_interface,
            "Android User Interface",
            " courseList.add(Courses(R.drawable.course_image,\n" +
                    "            \"Android App Development Course For Beginners\",\n" +
                    "        \" Welcome To The Complete Android Developer Course: Beginner To Advanced\\n\" +\n" +
                    "                \"⇉ Watch the promo video to see How You Can Begin Building And Developing Your Very Own Android Applications Today!\\n\" +\n" +
                    "                \"⇉ This Course is MASSIVE! You receive over 17+ hours of video content and 140+ lectures!\\n\" +\n" +
                    "                \"⇉ Join Over 275,000+ Students Who Have Enrolled In My Udemy Courses This Year!\\n\" +\n" +
                    "                \"⇉ 7,500+ Five Star Reviews on our courses prove Students Who Enrolling Are Getting Real Results!\\n\" +\n" +
                    "                \"Then this course is for you! Click \\\"Take This Course Now\\\" For Instant Life-Time Access!\"))"))

        courseList.add(Courses(R.drawable.unit_testing,
            "Android Unit Testing Development",
            "Unit testing is widely considered one of the most important skills for senior Android developers to have. It's a great investment into medium- and long-term professional career growth.\n" +
                    "\n" +
                    "If bugs slip into your Android application, it can be very challenging to locate and fix them. Furthermore, even after you fix the bugs, it can take days or even weeks until all your users update the app to actually receive these fixes. That's a tough reality of professional Android developer's job. Fortunately, you can greatly reduce the number of bugs in your applications by unit testing your code!\n" +
                    "\n" +
                    "To make your applications unit testable, you'll need to write decoupled code that follows best design principles. This automatically guarantees easier long-term maintenance. In addition, unit testing makes developing Android applications easier and spares a lot of time when done right. "))
        //setting adapter and recyclerview layout
        courseAdapter = CourseAdapter(courseList)
        chooseLayout()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater): Boolean {
        //inflate the layout
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.switch_action)
        if (layoutButton != null) {
            setIcon(layoutButton)
        }

        return true
    }
    private fun chooseLayout(){
        if (isGridLayoutManager){
            recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        } else {
            recyclerView.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        }
        recyclerView.adapter = courseAdapter

    }
    private fun setIcon(menuItem: MenuItem) {

        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_grid)
            else {
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_staggered_grid)
            }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.switch_action -> {
                isGridLayoutManager = !isGridLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}