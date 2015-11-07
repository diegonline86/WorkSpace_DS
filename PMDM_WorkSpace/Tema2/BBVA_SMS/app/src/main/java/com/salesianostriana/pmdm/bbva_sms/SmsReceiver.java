package com.salesianostriana.pmdm.bbva_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Diego on 22/10/2015.
 */
public class SmsReceiver extends BroadcastReceiver {
    String message;

    public SmsReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        try{
            if(bundle != null){
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for(int i = 0; i < pdusObj.length; i++){
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                    // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                            "senderNum: " + senderNum + ", message: " + message, duration);
                    toast.show();
                }
            }
        }catch (Exception e){
            Log.e("SmsReceiver", e.getMessage());
        }
    }

    public String getMessage(){
        return message;
    }
}
