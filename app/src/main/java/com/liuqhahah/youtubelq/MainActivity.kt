package com.liuqhahah.youtubelq

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView_main.layoutManager = LinearLayoutManager(this)
//        recyclerView_main.adapter = MainAdapter()

        fetchJson()
    }

    fun fetchJson() {
        println("Attempting to fetch JSON")

        val url ="https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        //主线程不给进行网络操作
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson =  GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread{
                    recyclerView_main.adapter = MainAdapter(homeFeed)
                }
            }
        })
    }


//    id: 1,
//    name: "Instagram Firebase - Learn How to Create Users, Follow, and Send Push Notifications",
//    link: "https://www.letsbuildthatapp.com/course/instagram-firebase",
//    imageUrl: "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/04782e30-d72a-4917-9d7a-c862226e0a93",
//    numberOfViews: 20000,
//    channel: {
//        name: "Lets Build That App",
//        profileImageUrl: "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf",
//        numberOfSubscribers: 100000,
//    },


    class HomeFeed(val videos: List<Video>)

    class Video(val id: Int,val name:String,val link:String,val imageUrl:String,
                val numberOfViews:Int,val channel: Channel)

    class Channel(val name: String,val profileImageUrl: String)
}
