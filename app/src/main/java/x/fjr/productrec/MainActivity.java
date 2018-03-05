package x.fjr.productrec;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import x.fjr.productrec.app.App;
import x.fjr.productrec.app.AppListAdapter;
import x.fjr.productrec.category.CategoryApp;

public class MainActivity extends AppCompatActivity {

    RecyclerView startSnapRecyclerView;
    LinearLayoutManager layoutManagerStart;
    AppListAdapter appListStartAdapter;
    GravitySnapHelper snapHelper;

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


        ArrayList<CategoryApp> categoryApps = setData();
        ArrayList<ArrayList<CategoryApp>> pagingCategoryApps = new ArrayList<>();
        int maxPerPage = 5;

        for (int index=0; index<categoryApps.size(); index++) {
            if(index % maxPerPage == 0) {
                pagingCategoryApps.add(new ArrayList<CategoryApp>());
            }

            pagingCategoryApps.get(pagingCategoryApps.size() - 1).add(categoryApps.get(index));
        }

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagingAdapter viewPagingAdapter = new ViewPagingAdapter(getSupportFragmentManager(), pagingCategoryApps);
        viewPager.setAdapter(viewPagingAdapter);

        startSnapRecyclerView = findViewById(R.id.startSnapRecyclerView);
        layoutManagerStart = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        startSnapRecyclerView.setLayoutManager(layoutManagerStart);
        appListStartAdapter = new AppListAdapter(this);
        startSnapRecyclerView.setAdapter(appListStartAdapter);
        snapHelper = new GravitySnapHelper(Gravity.START);

        //first 0 -> first category paging
        //second 0 -> first category
        setDataFromCategory(new GridItemMessageEvent(pagingCategoryApps.get(0).get(0)));

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setDataFromCategory(GridItemMessageEvent event) {
        CategoryApp categoryApp = event.categoryApp;
        appListStartAdapter.updateList(categoryApp.appList);
        snapHelper.attachToRecyclerView(startSnapRecyclerView);
        startSnapRecyclerView.scrollToPosition(0);
    }

    private ArrayList<CategoryApp> setData() {
        ArrayList<CategoryApp> categoryApps = new ArrayList<>();

        CategoryApp categoryApp1 = new CategoryApp();
        categoryApp1.categoryName = "cat app 1";
        ArrayList<App> apps1 = new ArrayList<>();
        apps1.add(new App("WhatsApp 1", R.drawable.ic_whatsapp));
        apps1.add(new App("Skype 1", R.drawable.ic_skype));
        apps1.add(new App("Facebook 1", R.drawable.ic_facebook));
        apps1.add(new App("Google+ 1", R.drawable.ic_gplus));
        apps1.add(new App("Instagram 1", R.drawable.ic_instagram));
        categoryApp1.appList = apps1;

        CategoryApp categoryApp2 = new CategoryApp();
        categoryApp2.categoryName = "cat app 2";
        ArrayList<App> apps2 = new ArrayList<>();
        apps2.add(new App("WhatsApp 2", R.drawable.ic_whatsapp));
        apps2.add(new App("Skype 2", R.drawable.ic_skype));
        apps2.add(new App("Facebook 2", R.drawable.ic_facebook));
        apps2.add(new App("Google+ 2", R.drawable.ic_gplus));
        apps2.add(new App("Instagram 2", R.drawable.ic_instagram));
        categoryApp2.appList = apps2;

        CategoryApp categoryApp3 = new CategoryApp();
        categoryApp3.categoryName = "cat app 3";
        ArrayList<App> apps3 = new ArrayList<>();
        apps3.add(new App("WhatsApp 3", R.drawable.ic_whatsapp));
        apps3.add(new App("Skype 3", R.drawable.ic_skype));
        apps3.add(new App("Facebook 3", R.drawable.ic_facebook));
        apps3.add(new App("Google+ 3", R.drawable.ic_gplus));
        apps3.add(new App("Instagram 3", R.drawable.ic_instagram));
        categoryApp3.appList = apps3;

        CategoryApp categoryApp4 = new CategoryApp();
        categoryApp4.categoryName = "cat app 4";
        ArrayList<App> apps4 = new ArrayList<>();
        apps4.add(new App("WhatsApp 4", R.drawable.ic_whatsapp));
        apps4.add(new App("Skype 4", R.drawable.ic_skype));
        apps4.add(new App("Facebook 4", R.drawable.ic_facebook));
        apps4.add(new App("Google+ 4", R.drawable.ic_gplus));
        apps4.add(new App("Instagram 4", R.drawable.ic_instagram));
        categoryApp4.appList = apps4;

        CategoryApp categoryApp5 = new CategoryApp();
        categoryApp5.categoryName = "cat app 5";
        ArrayList<App> apps5 = new ArrayList<>();
        apps5.add(new App("WhatsApp 5", R.drawable.ic_whatsapp));
        apps5.add(new App("Skype 5", R.drawable.ic_skype));
        apps5.add(new App("Facebook 5", R.drawable.ic_facebook));
        apps5.add(new App("Google+ 5", R.drawable.ic_gplus));
        apps5.add(new App("Instagram 5", R.drawable.ic_instagram));
        categoryApp5.appList = apps5;

        CategoryApp categoryApp6 = new CategoryApp();
        categoryApp6.categoryName = "cat app 6";
        ArrayList<App> apps6 = new ArrayList<>();
        apps6.add(new App("WhatsApp 6", R.drawable.ic_whatsapp));
        apps6.add(new App("Skype 6", R.drawable.ic_skype));
        apps6.add(new App("Facebook 6", R.drawable.ic_facebook));
        apps6.add(new App("Google+ 6", R.drawable.ic_gplus));
        apps6.add(new App("Instagram 6", R.drawable.ic_instagram));
        categoryApp6.appList = apps6;

        categoryApps.add(categoryApp1);
        categoryApps.add(categoryApp2);
        categoryApps.add(categoryApp3);
        categoryApps.add(categoryApp4);
        categoryApps.add(categoryApp5);
        categoryApps.add(categoryApp6);

        return categoryApps;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
