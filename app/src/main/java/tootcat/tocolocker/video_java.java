package tootcat.tocolocker;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.VideoView;
import android.net.Uri;




public class video_java extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.video_activity);


        videoView = (VideoView) findViewById(R.id.videoView);

        String video=getIntent().getStringExtra("video");
        Uri uri=Uri.parse(video);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                video_java.this.finish();
            }
        });

    }
}