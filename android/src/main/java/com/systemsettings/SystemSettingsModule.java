package com.systemsettings;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableNativeArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

public class SystemSettingsModule extends ReactContextBaseJavaModule {

	static final String TAG = "SystemSettingsModule";

	public SystemSettingsModule (ReactApplicationContext reactContext) {
		super(reactContext);
	}


	@Override
  public String getName() {
    return "SystemSettings";
  }


	@ReactMethod
  public void get(Callback callback) {
		Configuration conf = getReactApplicationContext().getResources().getConfiguration();

		Locale locale = conf.locale;

		WritableMap localeMap = new WritableNativeMap();
		localeMap.putString("language", locale.getLanguage());
		localeMap.putString("country", locale.getCountry());
		localeMap.putString("localization", locale.toString());
		localeMap.putString("displayCountry", locale.getDisplayCountry());
		localeMap.putString("displayName", locale.getDisplayName());
		localeMap.putString("displayLanguage", locale.getDisplayLanguage());

		WritableMap result = new WritableNativeMap();
		result.putMap("locale", localeMap);
		result.putInt("densityDpi", conf.densityDpi);
		result.putDouble("fontScale", conf.fontScale);

		String hardKeyboardHidden = null;
		if (conf.hardKeyboardHidden == 0) {
			hardKeyboardHidden = "undefined";
		} else if (conf.hardKeyboardHidden == 1) {
			hardKeyboardHidden = "no";
		} else {
			hardKeyboardHidden = "yes";
		}
		result.putString("hardKeyboardHidden", hardKeyboardHidden);

		String keyboardHidden = null;
		if (conf.keyboardHidden == 0) {
			keyboardHidden = "undefined";
		} else if (conf.keyboardHidden == 1) {
			keyboardHidden = "no";
		} else {
			keyboardHidden = "yes";
		}
		result.putString("keyboardHidden", keyboardHidden);

		String keyboard = null;
		if (conf.keyboard == 0) {
			keyboard = "undefined";
		} else if (conf.keyboard == 1) {
			keyboard = "nokeys";
		} else if (conf.keyboard == 2) {
			keyboard = "qwerty";
		} else {
			keyboard = "12key";
		}
		result.putString("keyboard", keyboard);

		String orientation = null;
		if (conf.orientation == 0) {
			orientation = "undefined";
		} else if (conf.orientation == 1) {
			orientation = "portrait";
		} else if (conf.orientation == 2) {
			orientation = "landscape";
		} else {
			orientation = "square";
		}
		result.putString("orientation", orientation);

		result.putInt("screenHeightDp", conf.screenHeightDp);
		result.putInt("screenWidthDp", conf.screenWidthDp);

		int screenLayoutInt = getReactApplicationContext().getResources().getConfiguration().screenLayout;
		screenLayoutInt &= Configuration.SCREENLAYOUT_SIZE_MASK;
    String screenLayout = null;
    if (screenLayoutInt == Configuration.SCREENLAYOUT_SIZE_SMALL) {
      screenLayout = "small";
		} else if (screenLayoutInt == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
			screenLayout = "normal";
		} else if (screenLayoutInt == Configuration.SCREENLAYOUT_SIZE_LARGE) {
			screenLayout = "large";
		} else if (screenLayoutInt == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
			screenLayout = "xlarge";
		} else {
			screenLayout = "undefined";
		}
		result.putString("screenLayout", screenLayout);

		result.putInt("smallestScreenWidthDp", conf.smallestScreenWidthDp);

		UiModeManager uiModeManager = (UiModeManager) getReactApplicationContext().getSystemService(Context.UI_MODE_SERVICE);
		int uiModeTypeInt = uiModeManager.getCurrentModeType();
		String uiModeType = null;
		if (uiModeTypeInt ==  Configuration.UI_MODE_TYPE_UNDEFINED) {
			uiModeType = "undefined";
		} else if (uiModeTypeInt == Configuration.UI_MODE_TYPE_NORMAL) {
			uiModeType = "normal";
		} else if (uiModeTypeInt == Configuration.UI_MODE_TYPE_DESK) {
			uiModeType = "desk";
		} else if (uiModeTypeInt == Configuration.UI_MODE_TYPE_CAR) {
			uiModeType = "car";
		} else if (uiModeTypeInt == Configuration.UI_MODE_TYPE_TELEVISION) {
			uiModeType = "television";
		} else if (uiModeTypeInt == Configuration.UI_MODE_TYPE_APPLIANCE) {
			uiModeType = "appliance";
		} else if (uiModeTypeInt == Configuration.UI_MODE_TYPE_WATCH) {
			uiModeType = "watch";
		}
		result.putString("uiModeType", uiModeType);

		callback.invoke(result);
  }

}
