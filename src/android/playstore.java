package com.stlindia.playstore;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.telephony.TelephonyManager;
import android.content.Context;
import android.util.Log;
import android.content.Intent;
import android.net.Uri;

public class playstore extends CordovaPlugin {
	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
       System.out.println("###### got the request");
		if (action.equals("openPlaystoreApp")) {
			System.out.println("###### entered inside if");
			System.out.println("#### App Package Name"+args.getString(0));
            this.openGooglePlaystoreWithApplication(callbackContext,args.getString(0));
            return true;
        }
		System.out.println("###### outside of else");
        return false;
    }
    
	private void openGooglePlaystoreWithApplication(CallbackContext callbackContext,String package_name){
		System.out.println("###### Function called");
		System.out.println("#### App Package Name Inside function"+package_name);
		Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + package_name));
        marketIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET|Intent.FLAG_ACTIVITY_MULTIPLE_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        cordova.getActivity().startActivity(marketIntent);
	}
} 
