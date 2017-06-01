package com.example.login1.broadcastDemo;



import java.util.zip.Inflater;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sendsms extends BroadcastReceiver {
	private static final String strRes= "android.provider.Telephony.SMS_RECEIVED";	
	public String data;
	
	//private BRInteraction bInteraction;
	@Override
	public void onReceive(Context context, Intent intent) {
		SharedPreferences spPreferences;
		SharedPreferences.Editor editor;
		spPreferences = context.getSharedPreferences("dududu", Context.MODE_APPEND);
		editor = spPreferences.edit();
		// TODO Auto-generated method stub
		System.out.println("接收短信执行了");
		if (intent.getAction().equals(strRes)) {
			//StringBuilder sb = new StringBuilder();
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
			Object[] pdus = (Object[]) bundle.get("pdus");
			SmsMessage[] msg = new SmsMessage[pdus.length];
			for (int i = 0; i < pdus.length; i++) {
			msg[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
			String sender=msg[i].getDisplayOriginatingAddress();
			String content=msg[i].getMessageBody();
	    	
			if("11234".equals(sender)){
				System.out.println(" abort ");
				editor.putString("number", sender);
				editor.putString("content", content);
				editor.commit();
			Toast.makeText(context,"Got The Message:"+content,Toast.LENGTH_LONG).show();
			//AlertDialog.Builder builder = new AlertDialog.Builder(context);
			AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
			//builder.setIcon(R.drawable.button);
			builder.setTitle("来短信啦");
			builder.setMessage(content);
			builder.setPositiveButton("OK", null);
			AlertDialog dia = builder.create();
			dia.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
			dia.setCanceledOnTouchOutside(true);
			dia.show();
			abortBroadcast();
				//发送短信
				SmsManager manager=SmsManager.getDefault();
				manager.sendTextMessage("10086", null, "aaa", null, null);
			}
			}

	}
	 
}}
}
