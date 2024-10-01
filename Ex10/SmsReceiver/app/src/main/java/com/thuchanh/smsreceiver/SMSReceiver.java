package com.thuchanh.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            // Xử lý tin nhắn SMS nhận được ở đây
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                for (Object pdu : pdus) {
                    //create a new SMSMessage
                    SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);
                    String sender = message.getDisplayOriginatingAddress();
                    String body = message.getDisplayMessageBody();

                    // Display the sender and message body in a Toast
                    //Toast.makeText(context, "Sender: " + sender + " Message: " + body, Toast.LENGTH_LONG).show();
                    //use log
                    Log.d("SMSReceiver", "Sender: " + sender + " Message: " + body);
                }
            }
        }
    }
}
