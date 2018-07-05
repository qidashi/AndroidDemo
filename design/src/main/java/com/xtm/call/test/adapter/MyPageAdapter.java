package com.xtm.call.test.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xtm.call.test.fragment.BlankFragment;

import java.util.List;

/**
 * Function:
 * Created by TianMing.Xiong on 18-7-4.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    private List<String> list ;

    public MyPageAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return BlankFragment.newInstance(list.get(i));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
