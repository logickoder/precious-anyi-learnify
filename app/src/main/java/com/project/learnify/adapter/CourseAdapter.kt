package com.project.learnify.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.project.learnify.HomeScreenFragmentDirections
import com.project.learnify.R
import com.project.learnify.model.Courses

class CourseAdapter(private val courseList: ArrayList<Courses>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View): RecyclerView.ViewHolder(view){

        //initializing the views in item_design xml
        val courseTitle: TextView = view.findViewById(R.id.mcourse_title)
        val courseDetails: TextView = view.findViewById(R.id.mcourse_details)
        val imageview: ImageView = view.findViewById(R.id.course_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_design, parent,false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.courseTitle.text = course.courseTitle
        holder.courseDetails.text = course.courseDetail
        holder.imageview.setImageResource(course.image)
        holder.itemView.setOnClickListener{
            val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToCourseDetailsFragment(
                course.courseTitle,course.image,course.courseDetail)
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
     return courseList.size
    }
}