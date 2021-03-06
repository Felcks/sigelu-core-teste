package com.sigelu.core.mobile.logger;

import android.util.Log;

public class Logger {

    private final String TAG = "Logger";

    public void error(String message) {
        error(TAG, message);
    }

    public void error(String tag, String message) {
        Log.e(tag, message);
    }
}