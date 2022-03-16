    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
       if (status==BluetoothGatt.GATT_SUCCESS){
           handler.sendEmptyMessage(newState);
       }else {
           Log.i("GitCode", "gatt fail");
           handler.sendEmptyMessage(CONNECTED_FAIL);
       }
    }

