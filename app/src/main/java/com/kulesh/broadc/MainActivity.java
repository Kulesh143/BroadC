package com.kulesh.broadc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//Broadcast receiver is an Android component which allows you to send or receive Android system or application events.
//All the registered application are notified by the Android runtime once event happens.
//It works similar to the publish-subscribe design pattern and used for asynchronous inter-process communication.
//


public class MainActivity extends AppCompatActivity {
TextView air;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     air=findViewById(R.id.airr);
     ReceiverOne one=new ReceiverOne();
        IntentFilter filter=new IntentFilter();
        filter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(one,filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ReceiverOne one=new ReceiverOne();
        unregisterReceiver(one);

    }
    public class ReceiverOne extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean state=intent.getBooleanExtra("state",false);
            if(state){
                air.setText("AIRPLANE MODE ON");
                Toast.makeText(context, "AIRPLANE MODE ON", Toast.LENGTH_SHORT).show();
            }else{
                air.setText("AIRPLANE MODE OFF");
                Toast.makeText(context, "AIRPLANE MODE OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }


}