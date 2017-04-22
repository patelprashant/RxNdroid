package com.practice.android.rxndroid;

import android.app.Activity;

public class SampleActivityWithName {
    public final Class<? extends Activity> mSampleActivityClass;
    public final int mSampleName;

    public SampleActivityWithName(Class<? extends Activity> mSampleActivityClass, int mSampleName) {
        this.mSampleActivityClass = mSampleActivityClass;
        this.mSampleName = mSampleName;
    }
}
