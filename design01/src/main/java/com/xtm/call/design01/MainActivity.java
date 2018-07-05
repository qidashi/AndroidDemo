package com.xtm.call.design01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) tvTest.getLayoutParams();
        SwipeDismissBehavior<TextView> behaviour = new SwipeDismissBehavior<>();
        layoutParams.setBehavior(behaviour);
        behaviour.setListener(this);

    }

    private void initView() {
        tvTest = (TextView) findViewById(R.id.tv_test);
    }

    @Override
    public void onDismiss(final View view) {
        tvTest.setVisibility(View.GONE);
        Snackbar.make(view,"你删除了一个条目",Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTest.setVisibility(View.VISIBLE);
                        ViewCompat.animate(view).alpha(1).start();
                    }
                })
                .show();
    }

    @Override
    public void onDragStateChanged(int i) {

    }

    /**
     * 退出整个应用
     * @param view
     */
    public void exit(View view) {
         Snackbar snackbar = Snackbar.make(view, "你确定要退出吗？", Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAffinity(MainActivity.this);
            }
        });
        snackbar.show();

    }

    public void next(View view) {
        startActivity(new Intent(this,CoordatorActivity.class));
    }
}
