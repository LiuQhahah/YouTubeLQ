package com.liuqhahah.youtubelq

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

/**
 * Created by liu on 3/3/18.
 */

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>(){


    //创建显示video标题的数据
    val videoTitles = listOf("First title","Second","3rd","MOOOOORE TITLE")


    //numberofItems
    override fun getItemCount(): Int {
        //调用.size，动态设置页面中list的个数
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder{
        //how do we even create a view
        //将布局文件R.layout.video_row
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row,parent,false)
        return CustomViewHolder(cellForRow)

    }
    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

        //将postion与video Title挂钩，滑动到哪一个位置，就显示数组对应的video title
//        val videoTitle = videoTitles.get(position)
        val video = homeFeed.videos.get(position)
        holder?.view?.textView_channel_view?.text = video.channel.name +"  ,  20k Views\n"+"4 days ago"
        holder?.view?.textView_video_title?.text = video.name

        //显示视频封面
        val thumbnailImageView  = holder?.view?.imageView_view_thumbnail
        Picasso.with(holder?.view?.context).load(video.imageUrl).into(thumbnailImageView)

        //显示频道封面
        val channelProfileImageView = holder?.view?.imageView_channel_profile
        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl)
                .into(channelProfileImageView)



        holder?.video = video
    }
}

class CustomViewHolder(val view :View,var video:Video? = null): RecyclerView.ViewHolder(view){

    companion object{
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }
    init {
        view.setOnClickListener {

            val intent = Intent(view.context,CourseDetailActivity::class.java)

            intent.putExtra(VIDEO_TITLE_KEY,video?.name)
            intent.putExtra(VIDEO_ID_KEY,video?.id)

            view.context.startActivity(intent)
        }
    }

}