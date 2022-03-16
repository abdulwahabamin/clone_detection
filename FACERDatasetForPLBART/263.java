    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            if (newState==BluetoothProfile.STATE_CONNECTED){
                handler.sendEmptyMessage(MainActivity.GATT_CONNECTED);
            }else if (newState==BluetoothProfile.STATE_DISCONNECTED){
                handler.sendEmptyMessage(MainActivity.GATT_DISCONNECTED);
            }
        }else{
            Log.e(TAG,"operation failure");
        }
    }

