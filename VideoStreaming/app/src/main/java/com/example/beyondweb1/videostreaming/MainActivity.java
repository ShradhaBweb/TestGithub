package com.example.beyondweb1.videostreaming;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;


/**
 * Created by Igor Khrupin www.hrupin.com on 1/20/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    String video_uri = "http://techslides.com/demos/sample-videos/small.mp4";
    private Button buttonVideoSample;
    ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
        try {
            img.setImageBitmap(retriveVideoFrameFromVideo(video_uri));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        buttonVideoSample = (Button) findViewById(R.id.buttonVideoSample);
        img.setOnClickListener(this);
    }

    public void onClick(View v) {
//        if (v.getId() == R.id.buttonVideoSample) {
            // **********************************
            // HERE SET YOUR VIDEO URI
            // HERE SET YOUR VIDEO URI
            // For example: http://www.hrupin.com/wp-content/uploads/2016/01/sample_video.3gp
            // **********************************

            Intent intent = new Intent(this, VideoSample.class);
            intent.putExtra("video_path", video_uri);
            startActivity(intent);
//        }
    }

    public static Bitmap retriveVideoFrameFromVideo(String videoPath) throws Throwable
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try
        {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);
            //   mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Throwable("Exception in retriveVideoFrameFromVideo(String videoPath)" + e.getMessage());

        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }
}