    @Override
    protected void onDestroy() {
        BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
        if(mScanBroadcastReceiver != null){
            unregisterReceiver(mScanBroadcastReceiver);
            mScanBroadcastReceiver = null;
        }
        if(mPairBroadcastReceiver != null){
            unregisterReceiver(mPairBroadcastReceiver);
            mPairBroadcastReceiver = null;
        }
        super.onDestroy();
    }

