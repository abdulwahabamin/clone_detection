    private void beginDiscover(){
        if(mScanBroadcastReceiver == null){
            mScanBroadcastReceiver = new ScanBroadcastReceiver(scanCallback);
        }
        //æ³¨å†Œè“?ç‰™æ‰«æ??ç›‘å?¬å™¨
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mScanBroadcastReceiver, intentFilter);
        BluetoothUtil.enableBluetooth((Activity) mContext, 1);
    }

