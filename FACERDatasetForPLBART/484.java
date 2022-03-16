    private void beginDiscover(){
        if(mScanBroadcastReceiver == null){
            mScanBroadcastReceiver = new ScanBroadcastReceiver(scanCallback);
        }
        //注册�?牙扫�??监�?�器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mScanBroadcastReceiver, intentFilter);
        BluetoothUtil.enableBluetooth((Activity) mContext, 1);
    }

