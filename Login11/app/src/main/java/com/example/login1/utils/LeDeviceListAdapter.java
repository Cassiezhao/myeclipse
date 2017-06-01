package com.example.login1.utils;

/**
 * Created by hell_blade on 2016/12/16.
 */


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.login1.utils.iBeaconClass.iBeacon;

import java.util.ArrayList;

public class LeDeviceListAdapter extends BaseAdapter {

    // Adapter for holding devices found through scanning.

    private final static double DISTANCE = 5.0;//设置的感应范围
    private ArrayList<iBeacon> mLeDevices;
    //private LayoutInflater mInflator;
    private Activity mContext;
    //private int position;

    public LeDeviceListAdapter(Activity c) {
        super();
        mContext = c;
        mLeDevices = new ArrayList<iBeacon>();
        //mInflator = mContext.getLayoutInflater();
    }

    public void addDevice(iBeacon device) {
        if(device==null)
            return;

        for(int i=0;i<mLeDevices.size();i++){
            String btAddress = mLeDevices.get(i).bluetoothAddress;
            if(btAddress.equals(device.bluetoothAddress)){
                mLeDevices.add(i+1, device);
                mLeDevices.remove(i);
                return;
            }
        }
        mLeDevices.add(device);

    }

    //通过比较从列表中获取位置信息
    public int getPosition(){
        int position = 0;
        for(int i=0;i<mLeDevices.size();i++) {
            if(mLeDevices.get(i).distance<DISTANCE)
            {
                position = mLeDevices.get(i).minor;
                break;
            }
            else{
                position=0;
            }
        }

        return position;
    }


    public iBeacon getDevice(int position) {
        return mLeDevices.get(position);
    }

    public void clear() {
        mLeDevices.clear();
    }

    @Override
    public int getCount() {
        return mLeDevices.size();
    }

    @Override
    public Object getItem(int i) {
        return mLeDevices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//		ViewHolder viewHolder;
//
//		// General ListView optimization code.
//		if (view == null) {
//			view = mInflator.inflate(R.layout.listitem_device, null);
//			viewHolder = new ViewHolder();
//			viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
//			viewHolder.deviceName = (TextView) view.findViewById(R.id.device_name);
//			viewHolder.deviceUUID= (TextView)view.findViewById(R.id.device_beacon_uuid);
//			viewHolder.deviceMajor_Minor=(TextView)view.findViewById(R.id.device_major_minor);
//			viewHolder.devicetxPower_RSSI=(TextView)view.findViewById(R.id.device_txPower_rssi);
//			view.setTag(viewHolder);
//		} else {
//			viewHolder = (ViewHolder) view.getTag();
//		}
//
//		iBeacon device = mLeDevices.get(i);
//		position=getPosition();
//		final String deviceName = device.name;
//		if (deviceName != null && deviceName.length() > 0)
//			viewHolder.deviceName.setText(deviceName);
//		else
//			viewHolder.deviceName.setText(R.string.unknown_device);
//
//		viewHolder.deviceAddress.setText(device.bluetoothAddress);
//		viewHolder.deviceUUID.setText(device.proximityUuid);
//		viewHolder.deviceMajor_Minor.setText("major:"+device.major+",minor:"+device.minor);
//		viewHolder.devicetxPower_RSSI.setText("txPower:"+device.txPower+",rssi:"+device.rssi+",distance:"+device.distance+"m"+",position:"+position);

        return null;
    }

//	class ViewHolder {
//		TextView deviceName;
//		TextView deviceAddress;
//		TextView deviceUUID;
//		TextView deviceMajor_Minor;
//		TextView devicetxPower_RSSI;
//		TextView deviceDistance;
//	}
}
