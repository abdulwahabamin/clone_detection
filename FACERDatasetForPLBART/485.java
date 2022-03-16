    private void startPair(){
        if(mPairBroadcastReceiver == null){
            mPairBroadcastReceiver = new PairBroadcastReceiver(pairCallback);
        }
        //æ³¨å†Œè“?ç‰™é…?å¯¹ç›‘å?¬å™¨
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(mPairBroadcastReceiver, intentFilter);
    }

