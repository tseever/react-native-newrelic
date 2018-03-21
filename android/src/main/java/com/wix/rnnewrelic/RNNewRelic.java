package com.wix.rnnewrelic;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.newrelic.agent.android.NewRelic;

/**
 * Created by rotemm on 29/06/2016.
 */
public class RNNewRelic extends ReactContextBaseJavaModule {

    public RNNewRelic(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void send(String name, ReadableMap eventAttributes) {
        NewRelic.recordCustomEvent(name, RNUtils.toHashMap((ReadableNativeMap) eventAttributes));
    }

    @ReactMethod
    public void recordBreadcrumb(String name, ReadableMap eventAttributes) {
        NewRelic.recordBreadcrumb(name, RNUtils.toHashMap((ReadableNativeMap) eventAttributes));
    }

    @ReactMethod
    public void startInteraction(String name) {
        NewRelic.startInteraction(name);
    }

    @ReactMethod
    public void stopInteraction(String name) {
        NewRelic.endInteraction(name);
    }

    @ReactMethod
    public void recordError(String name, ReadableMap eventAttributes) {
        Exception ex = new Exception(name);
        NewRelic.recordHandledException(ex, RNUtils.toHashMap((ReadableNativeMap) eventAttributes));
    }

    @ReactMethod
    public void setAttribute(String name, String value) {
        NewRelic.setAttribute(name , value);
    }

    @ReactMethod
    public void nativeLog(String message) {
        Log.d(getName(), message);
    }

    @Override
    public String getName() {
        return "RNNewRelic";
    }
}