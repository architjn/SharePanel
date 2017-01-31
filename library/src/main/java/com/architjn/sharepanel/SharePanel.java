package com.architjn.sharepanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;

/**
 * Created by architjn on 01/31/2017.
 */

public class SharePanel extends CardView {

    private CoordinatorLayout parentView;
    private Context context;
    private AttributeSet attrs;
    private HookView hookView;
    private SlideHideBehaviour behaviour;
    private int[] keys = new int[]{
            R.styleable.SharePanelAttrs_app_layout_anchor
    };
    private TypedArray ta;

    public SharePanel(Context context) {
        super(context);
        init(context, null);
    }

    public SharePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SharePanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (getParent() instanceof CoordinatorLayout) {
            parentView = ((CoordinatorLayout) getParent());
            parentView.addView(hookView);
            if (attrs != null) {
                CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) hookView.getLayoutParams();
                lp.anchorGravity = Gravity.RIGHT | Gravity.END | Gravity.BOTTOM;
                lp.setAnchorId(ta.getResourceId(R.styleable.SharePanelAttrs_app_layout_anchor, -1));
                hookView.setLayoutParams(lp);
            }
            CoordinatorLayout.LayoutParams lp1 = (CoordinatorLayout.LayoutParams) getLayoutParams();
            lp1.setBehavior(behaviour);
            setCardElevation(Utils.dpToPx(context, 5));
            setLayoutParams(lp1);
        }
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        this.attrs = attrs;
        ta = context.obtainStyledAttributes(attrs, R.styleable.SharePanelAttrs, 0, 0);
        hookView = new HookView(context);
        behaviour = new SlideHideBehaviour(context, attrs);
    }
}
