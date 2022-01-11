package com.kulesh.broadc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.kulesh.broadc.model.ReceiverTwo;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    TextView airrrr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        airrrr=findViewById(R.id.airrrr);
          ReceiverTwo two=new ReceiverTwo();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(two, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ReceiverTwo two=new ReceiverTwo();
        unregisterReceiver(two);
    }
    public class ReceiverTwo extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(checkInternet(context))
            {
                airrrr.setText("Network Available Do operations");
                Toast.makeText(context, "Network Available Do operations",Toast.LENGTH_LONG).show();
            }else{
                airrrr.setText("Network Not Available");
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
}
