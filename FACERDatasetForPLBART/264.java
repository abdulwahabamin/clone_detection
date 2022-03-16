    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        if (status==BluetoothGatt.GATT_SUCCESS){
            handler.sendEmptyMessage(MainActivity.GATT_SERVICES_DISCOVER);
        }
    }

