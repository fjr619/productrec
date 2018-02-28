package x.fjr.productrec;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        RecyclerView startSnapRecyclerView = findViewById(R.id.startSnapRecyclerView);
        LinearLayoutManager layoutManagerStart
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        startSnapRecyclerView.setLayoutManager(layoutManagerStart);
        AppListAdapter appListStartAdapter = new AppListAdapter(this);
        startSnapRecyclerView.setAdapter(appListStartAdapter);

        List<App> appList = new ArrayList<>();

        appList.add(new App("WhatsApp", R.drawable.ic_whatsapp));
        appList.add(new App("Skype", R.drawable.ic_skype));
        appList.add(new App("Facebook", R.drawable.ic_facebook));
        appList.add(new App("Google+", R.drawable.ic_gplus));
        appList.add(new App("Instagram", R.drawable.ic_instagram));
        appList.add(new App("LinkedIn", R.drawable.ic_linkedin));
        appList.add(new App("Quora", R.drawable.ic_quora));
        appList.add(new App("Twitter", R.drawable.ic_twitter));
        appList.add(new App("Tumblr", R.drawable.ic_tumblr));
        appList.add(new App("Email", R.drawable.ic_email));
        appList.add(new App("Gallery", R.drawable.ic_gallery));

        appListStartAdapter.updateList(appList);


//        SnapHelper snapHelperStart = new StartSnapHelper();
        GravitySnapHelper snapHelper = new GravitySnapHelper(Gravity.CENTER);
        snapHelper.attachToRecyclerView(startSnapRecyclerView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
