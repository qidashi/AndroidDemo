package com.xtm.call.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xtm.call.test.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager viewpager;
    private DrawerLayout drawer;
    private LinearLayout container;
    private NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle listener = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(listener);
        listener.syncState();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.format(Locale.CHINA, "第%02d条", i));
        }
        viewpager.setAdapter(new MyPageAdapter(getSupportFragmentManager(), list));
        tab.setupWithViewPager(viewpager);

        navigation.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        tab = (TabLayout) findViewById(R.id.tab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        container = (LinearLayout) findViewById(R.id.container);
        navigation = (NavigationView) findViewById(R.id.navigation);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Toast.makeText(this, "menuItem.getItemId():" + menuItem.getItemId(), Toast.LENGTH_SHORT).show();
        drawer.closeDrawers();
        return true;
    }
}
