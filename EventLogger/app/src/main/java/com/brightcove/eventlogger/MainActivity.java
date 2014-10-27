package com.brightcove.eventlogger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;

import com.brightcove.player.event.EventEmitter;
import com.brightcove.player.event.EventLogger;
import com.brightcove.player.media.Catalog;
import com.brightcove.player.media.PlaylistListener;
import com.brightcove.player.model.Playlist;
import com.brightcove.player.view.BrightcoveVideoView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BrightcoveVideoView bcVideoView = (BrightcoveVideoView) findViewById(R.id.bc_video_view);
        final EventEmitter eventEmitter = bcVideoView.getEventEmitter();
        new EventLogger(eventEmitter, true, "bcEventLogger");

        final Catalog catalog = new Catalog("XGuquNMCweRY0D3tt_VUotzuyIASMAzhUS4F8ZIWa_e0cYlKpA4WtQ..");
        EventEmitter catEventEmmiter = catalog.getEventEmitter();
        new EventLogger(catEventEmmiter, true, "bcCatalogLogger");

        MediaController controller = new MediaController(this);
        bcVideoView.setMediaController(controller);

        catalog.findPlaylistByID("1752604519001", new PlaylistListener() {
            @Override
            public void onPlaylist(Playlist playlist) {
                bcVideoView.addAll(playlist.getVideos());
                bcVideoView.start();
            }

            @Override
            public void onError(String error) {
                //Insert error handling here
                Log.e("Error info: ", error);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
