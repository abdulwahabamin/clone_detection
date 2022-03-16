    private void startPair(){
        if(mPairBroadcastReceiver == null){
            mPairBroadcastReceiver = new PairBroadcastReceiver(pairCallback);
        }
        //注册�?牙�?对监�?�器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(mPairBroadcastReceiver, intentFilter);
    }

