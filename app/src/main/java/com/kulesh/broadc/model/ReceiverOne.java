package com.kulesh.broadc.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverOne extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean state=intent.getBooleanExtra("state",false);
        if(state){
            Toast.makeText(context, "AIRPLANE MODE ON", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "AIRPLANE MODE OFF", Toast.LENGTH_SHORT).show();
        }
    }
}
