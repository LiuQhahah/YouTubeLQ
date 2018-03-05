package com.liuqhahah.youtubelq

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*

/**
 *
 * Created by liu on 3/5/18.
 */
class CourseLessonActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course_lesson)
//        webview_course_lesson.setBackgroundColor(Color.YELLOW)


        val courseLink = intent.getStringExtra(CourseDetailActivity.CourseLessonViewHolder.COURSE_LESSON_LINK_KEY)
        println("link"+courseLink)
        webview_course_lesson.loadUrl(courseLink)
    }
}