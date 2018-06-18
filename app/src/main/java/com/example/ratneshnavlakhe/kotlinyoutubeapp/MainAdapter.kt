package com.example.ratneshnavlakhe.kotlinyoutubeapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf<String>("First Title", "Second", "3rd")
    //number of items
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // how do we create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        val videoTitle = videoTitles.get(position)
        val video = homeFeed.videos.get(position)
        holder.view.textView_video_title.text = video.name

        holder.view.textView_channel_name.text = video.channel.name + " • " + "20K Views\n4 days ago"

        val thumbnailImageView = holder.view.imageView_video_thumbnail
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView = holder.view.imageView_channel_profile
        Picasso.get().load(video.channel.profileImageUrl).into(channelProfileImageView)


    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}