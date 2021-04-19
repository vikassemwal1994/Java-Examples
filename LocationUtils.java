package com.mom.app.retail.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationUtils {

    public static boolean isGpsEnabled(Context context) {
        LocationManager service = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return service.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    public static Address getAddressFromLocation(Context context, double latitude, double longitude) throws IOException {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//        String city = addresses.get(0).getLocality();
//        String state = addresses.get(0).getAdminArea();
//        String country = addresses.get(0).getCountryName();
//        String postalCode = addresses.get(0).getPostalCode();
//        String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

        return addresses != null && addresses.size() > 0 ? addresses.get(0) : null;

    }


    public static String getPinCodeFromLocation(Context context, double latitude, double longitude) {
        String pinCode = "";
        try {
            pinCode = LocationUtils.getAddressFromLocation(context, latitude, longitude).getPostalCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pinCode;
    }

}
