package com.mom.app.retail.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import android.telephony.TelephonyManager;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mom.app.retail.activities.LoginActivity;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobileInfo {

    private static final String TAG = "MobileInfo";
    public static final int READ_PHONE_STATE = 225;


    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    //  res1.append(Integer.toHexString(b & 0xFF) + ":");
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }

                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }

    @SuppressLint("HardwareIds")
    public static String getAndroidId(Context context) {

        return Settings.Secure.getString(context.getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

    }

    public static void getMyIP(Context context, final IpListner listner) {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://wtfismyip" +
                ".com/text", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                listner.getIP(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listner.getIP("IP_ADDRESS");
            }
        });
        Volley.newRequestQueue(context).add(stringRequest);


    }

    @SuppressLint("HardwareIds")
    public static List<String> getIMEI(Activity context) {
        List<String> details = new ArrayList<>();
        try {

            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context
                    .TELEPHONY_SERVICE);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(context, AppConstant.READ_PHONE_STATE, READ_PHONE_STATE);
                }
                assert telephonyManager != null;
                details.add(telephonyManager.getImei());
                details.add(telephonyManager.getNetworkOperatorName());
                return details;

            } else {
                assert telephonyManager != null;
                details.add(telephonyManager.getDeviceId());
                details.add(telephonyManager.getNetworkOperatorName());
                return details;


            }
        } catch (Exception e) {
            return details;
        }


    }

    public interface IpListner {

        void getIP(String ipAddress);
    }

    public static List<String> getAndroidVersion() {
        List<String> details = new ArrayList<>();
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        int version = Build.VERSION.SDK_INT;
        String versionRelease = Build.VERSION.RELEASE;

        details.add(manufacturer);
        details.add(model);
        details.add(String.valueOf(version));
        details.add(versionRelease);

        return details;
    }

    public static String getFCMId(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(LoginActivity.PREFS_NAME, Context.MODE_PRIVATE);

       return  sharedPreferences.getString(AppConstant.fcmId, "NA");
    }

//    private static final String TAG = "MobileInfo";
//    public static final int READ_PHONE_STATE = 225;
//
//
//    public static String getMacAddr() {
//        try {
//            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
//            for (NetworkInterface nif : all) {
//                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;
//
//                byte[] macBytes = nif.getHardwareAddress();
//                if (macBytes == null) {
//                    return "";
//                }
//
//                StringBuilder res1 = new StringBuilder();
//                for (byte b : macBytes) {
//                    //  res1.append(Integer.toHexString(b & 0xFF) + ":");
//                    res1.append(String.format("%02X:", b));
//                }
//
//                if (res1.length() > 0) {
//                    res1.deleteCharAt(res1.length() - 1);
//                }
//
//                return res1.toString();
//            }
//        } catch (Exception ex) {
//        }
//        return "02:00:00:00:00:00";
//    }
//
//    @SuppressLint("HardwareIds")
//    private String getAndroidId(Context context) {
//
//        return Settings.Secure.getString(context.getApplicationContext().getContentResolver(),
//                Settings.Secure.ANDROID_ID);
//
//    }
//
//    private void getMyIP(Context context, final IpListner listner) {
//
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://wtfismyip" +
//                ".com/text", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                listner.getIP(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                listner.getIP("IP_ADDRESS");
//            }
//        });
//        Volley.newRequestQueue(context).add(stringRequest);
//
//
//    }
//
//    @SuppressLint("HardwareIds")
//    private List<String> getIMEI(Activity context) {
//        try {
//            List<String> details = new ArrayList<>();
//            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context
//                    .TELEPHONY_SERVICE);
//
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
//                        != PackageManager.PERMISSION_GRANTED) {
//
//                    ActivityCompat.requestPermissions(context, AppConstant.READ_PHONE_STATE, READ_PHONE_STATE);
//                }
//                assert telephonyManager != null;
//                details.add(telephonyManager.getImei());
//                details.add(telephonyManager.getNetworkOperatorName());
//                return details;
//
//            } else {
//                assert telephonyManager != null;
//                details.add(telephonyManager.getDeviceId());
//                details.add(telephonyManager.getNetworkOperatorName());
//                return details;
//
//
//            }
//        } catch (Exception e) {
//            return null;
//        }
//
//
//    }
//
//    public interface IpListner {
//
//        void getIP(String ipAddress);
//    }
//
//    public static String getFCMID(Context context) {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(LoginActivity.PREFS_NAME, Context.MODE_PRIVATE);
//        return sharedPreferences.getString(AppConstant.fcmId, "NULL");
//
//    }
//
//    public static List<String> getAndroidVersion() {
//        List<String> details = new ArrayList<>();
//        String manufacturer = Build.MANUFACTURER;
//        String model = Build.MODEL;
//        int version = Build.VERSION.SDK_INT;
//        String versionRelease = Build.VERSION.RELEASE;
//
//        details.add(manufacturer);
//        details.add(model);
//        details.add(String.valueOf(version));
//        details.add(versionRelease);
//
//        return details;
//    }
}
