package com.practice.android.rxndroid.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {
    float dpWidth;
    float dpHeight;

    public ScreenUtility(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics( displayMetrics );

        float density = activity.getResources().getDisplayMetrics().density;

        dpWidth = displayMetrics.widthPixels / density;
        dpHeight = displayMetrics.heightPixels / density;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public float getDpHeight() {
        return dpHeight;
    }
}
