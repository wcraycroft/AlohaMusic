package edu.miracostacollege.cs134.alohamusic;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMediaPlayer;
    private MediaPlayer ipuMediaPlayer;
    private VideoView hulaVideoView;

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukuleleButton = findViewById(R.id.ukuleleButton);
        ipuButton = findViewById(R.id.ipuButton);
        hulaButton = findViewById(R.id.hulaButton);

        hulaVideoView = findViewById(R.id.hulaVideoView);

        // Connect the players (media player and video view) to the resources
        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this, R.raw.ipu);

        Resources res = this.getResources();
        int id = R.raw.hula;
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + res.getResourcePackageName(id) + "/"
                + res.getResourceTypeName(id) + "/"
                + res.getResourceEntryName(id));
        hulaVideoView.setVideoURI(uri);
    }

    public void playMedia(View v)
    {
        switch (v.getId())
        {
            case R.id.ukuleleButton:
                // If music is not playing...
                if (!ukuleleMediaPlayer.isPlaying()) {
                    // Hide buttons
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    // Change text
                    ukuleleButton.setText(getString(R.string.ukulele_button_pause_text));
                    // Start media
                    ukuleleMediaPlayer.start();
                    break;
                }
                // If music is playing...
                else {
                    // Show buttons
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    // Change text
                    ukuleleButton.setText(getString(R.string.ukulele_button_play_text));
                    // Pause media
                    ukuleleMediaPlayer.pause();
                    break;
                }

            case R.id.ipuButton:
                // If music is not playing...
                if (!ipuMediaPlayer.isPlaying()) {
                    // Hide buttons
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                    // Change text
                    ipuButton.setText(getString(R.string.ipu_button_pause_text));
                    // Start media
                    ipuMediaPlayer.start();
                    break;
                }
                // If music is playing...
                else
                {
                    // Show buttons
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    // Change text
                    ipuButton.setText(getString(R.string.ipu_button_play_text));
                    // Pause media
                    ipuMediaPlayer.pause();
                    break;
                }

            case R.id.hulaButton:
                // If video is not playing...
                if (!hulaVideoView.isPlaying()) {
                    // Hide buttons
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    // Change text
                    hulaButton.setText(getString(R.string.hula_button_pause_text));
                    // Start media
                    hulaVideoView.start();
                    break;
                }
                // If video is playing
                else
                {
                    // Show buttons
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                    // Change text
                    hulaButton.setText(getString(R.string.hula_button_watch_text));
                    // Pause media
                    hulaVideoView.pause();
                    break;
                }

        }

    }
}
