package com.sportsinteactive.task.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utility    {

    private static Utility utility = null;


    public static Utility getInstance() {
        return utility == null ? (utility = new Utility()) : utility;
    }



    private boolean isNetworkAvailable(Context mContext) {
        int[] networkTypes = {ConnectivityManager.TYPE_MOBILE,
                ConnectivityManager.TYPE_WIFI,
                ConnectivityManager.TYPE_BLUETOOTH};
        try {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            for (int networkType : networkTypes) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null &&
                        activeNetworkInfo.getType() == networkType)
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean checkInternetConnection(Context mContext) {
        if (isNetworkAvailable(mContext)) {
            return true;
        } else {
//             Utility.getInstance().showToast(mContext, mContext.getString(R.string.noInterAvailable_text));
            return false;
        }
    }
}
