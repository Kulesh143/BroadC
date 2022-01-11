package com.kulesh.broadc.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kulesh.broadc.ServiceManager;

public class ReceiverTwo extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(checkInternet(context))
        {
            Toast.makeText(context, "Network Available Do operations",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Network Not Available", Toast.LENGTH_SHORT).show();
        }

    }

    boolean checkInternet(Context context) {
        ServiceManager serviceManager = new ServiceManager(context);
        if (serviceManager.isNetworkAvailable()) {
            return true;
        } else {
            return false;
        }
    }

}