package com.practice.android.rxndroid;

import android.app.Activity;

public class SampleActivityWithName {
    public final Class<? extends Activity> mSampleActivityClass;
    public final String mSampleName;

    public SampleActivityWithName(Class<? extends Activity> mSampleActivityClass, String mSampleName) {
        this.mSampleActivityClass = mSampleActivityClass;
        this.mSampleName = mSampleName;
    }
}
