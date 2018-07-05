package com.xtm.call.design01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CoordatorActivity extends AppCompatActivity {

    private TextView tvShow;
    private RecyclerView recycler;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordator);
        initView();
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(String.format(Locale.CHINA, "第%03d条目", i));
        }
        recycler.setAdapter(new MyAdapter(list));
    }

    private void initView() {
        tvShow = (TextView) findViewById(R.id.tv_show);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
