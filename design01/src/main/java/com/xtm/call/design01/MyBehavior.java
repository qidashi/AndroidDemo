package com.xtm.call.design01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Function:
 * Created by TianMing.Xiong on 18-7-4.
 */

public class MyBehavior extends CoordinatorLayout.Behavior {
    public MyBehavior() {
        super();
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        if(dy>0){//上滑动隐藏
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        }else {
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }
    }
}
