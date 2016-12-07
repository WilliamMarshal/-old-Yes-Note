package com.vazhamarshal.yesnote.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;

import com.vazhamarshal.yesnote.R;

public class ExpandableLayout extends RelativeLayout implements Checkable {

    private ViewGroup mBody;

    public ExpandableLayout(Context context) {
        this(context, null);
    }

    public ExpandableLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mBody = (ViewGroup) (findViewById(R.id.card_view).findViewById(R.id.linear_root).findViewById(R.id.body));
    }

    @Override
    public void setChecked(boolean isChecked) {
        mBody.setVisibility(isChecked ? VISIBLE : GONE);
    }

    @Override
    public boolean isChecked() {
        return mBody.getVisibility() == VISIBLE;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }
}