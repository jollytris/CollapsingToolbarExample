package com.jollytris.collapsingtoolbarexample;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zic325 on 2016. 10. 21..
 */

public class BottomBehavior extends CoordinatorLayout.Behavior<View> {

    private boolean isShowing;

    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);

        AppBarLayout appBarLayout = (AppBarLayout) coordinatorLayout.findViewById(R.id.appBar);
        if (isShowing) {
            appBarLayout.setExpanded(true, true);
            ValueAnimator animator = ValueAnimator.ofFloat(child.getTranslationY(), 0);
            animator.addUpdateListener(animation -> {
                Float f = (Float) animation.getAnimatedValue();
                child.setTranslationY(f);
            });
            animator.start();
        } else {
            appBarLayout.setExpanded(false, true);
            ValueAnimator animator = ValueAnimator.ofFloat(child.getTranslationY(), child.getHeight());
            animator.addUpdateListener(animation -> {
                Float f = (Float) animation.getAnimatedValue();
                child.setTranslationY(f);
            });
            animator.start();
        }
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout,
                                  View child, View target, int dx, int dy, int[] consumed) {
        isShowing = dy < 0;
        float bottomTy = child.getTranslationY();
        int bottomHeight = child.getHeight();
        if ((bottomTy == bottomHeight && dy > 0)
                || (bottomTy == 0 && dy < 0)) {
        } else if (bottomTy + dy < 0) {
            child.setTranslationY(0);
        } else if (bottomTy + dy > bottomHeight) {
            child.setTranslationY(bottomHeight);
        } else {
            child.setTranslationY(bottomTy + dy);
        }
    }
}