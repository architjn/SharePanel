package com.architjn.sharepanel;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by architjn on 01/26/2017.
 */

public class SlideHideBehaviour extends CoordinatorLayout.Behavior<CardView> {

    private final Context context;
    private int screenWidth;
    private FastOutSlowInInterpolator interpolator;
    private float hiddenPosX, shownPosX, currentPos, hidingPos;
    private boolean animInProgress, notFirstRun;

    public SlideHideBehaviour(Context context, AttributeSet set) {
        super(context, set);
        this.context = context;
        init();
    }

    private void init() {
        screenWidth = Utils.getScreenWidth();
        interpolator = new FastOutSlowInInterpolator();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CardView child, View dependency) {
        return dependency instanceof Space;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CardView child, View dependency) {
        initValues(child);
        child.setY(dependency.getY() - child.getHeight() / 2);
        if (notFirstRun) {
            currentPos = dependency.getY();
            if (currentPos > hidingPos)
                animateIn(child);
            else animateOut(child);
        } else {
            child.setX(shownPosX);
            notFirstRun = true;
        }
        return false;
    }

    private void initValues(CardView child) {

        if (hidingPos == 0)
            hidingPos = ((AppCompatActivity) context).getSupportActionBar().getHeight() * 2;

        if (hiddenPosX == 0)
            hiddenPosX = screenWidth;

        if (shownPosX == 0)
            shownPosX = screenWidth - child.getWidth();
    }

    private void animateIn(final CardView view) {
        if (animInProgress)
            return;
        animInProgress = true;
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view).translationX(shownPosX)
                .setInterpolator(interpolator).withLayer()
                .setListener(new ViewPropertyAnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(View view1) {
                        super.onAnimationEnd(view1);
                        animInProgress = false;
                        if (currentPos > 400)
                            animateIn(view);
                        else animateOut(view);
                    }
                })
                .start();
    }

    private void animateOut(final CardView view) {
        if (animInProgress)
            return;
        animInProgress = true;
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view).translationX(hiddenPosX)
                .setInterpolator(interpolator).withLayer()
                .setListener(new ViewPropertyAnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(View view1) {
                        super.onAnimationEnd(view1);
                        animInProgress = false;
                        if (currentPos > 400)
                            animateIn(view);
                        else animateOut(view);
                    }
                })
                .start();
    }

}
