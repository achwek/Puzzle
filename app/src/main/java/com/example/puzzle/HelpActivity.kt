package com.example.puzzle

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {
    lateinit var videoView: VideoView;

    @SuppressLint("MissingInflatedId")
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
       val videopath = "android.resource://" + packageName + "/" + R.raw.helpmy
        val uri = Uri.parse(videopath)
        videoView= findViewById(R.id.videoViewHelp)
       videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.setOnCompletionListener {
            Toast.makeText(this@HelpActivity, "Thank you For Watching", Toast.LENGTH_SHORT).show()
        }
        videoView.setOnErrorListener { mp, what, extra ->
            Toast.makeText(this@HelpActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
            false
        }
        videoView.setOnPreparedListener { mp->
            videoView.start()
        }
    }
}