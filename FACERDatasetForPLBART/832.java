    public void readCustomCharacteristic() {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        /*check if the service is available on the device*/
//        BluetoothGattService mCustomService = mBluetoothGatt.getService(UUID.fromString("00001110-0000-1000-8000-00805f9b34fb"));
        if (mBluetoothGatt.getServices()!=null) {
            Log.w(TAG+"service", ""+ mBluetoothDeviceAddress);
        }
        BluetoothGattService mCustomService = mBluetoothGatt.getService(UUID.fromString("417D2ECD-E1F5-4945-A315-C5FC949C6248"));
        if(mCustomService == null){
            Log.w(TAG, "Custom BLE Service not found");
            return;
        }
        /*get the read characteristic from the service*/
        BluetoothGattCharacteristic mReadCharacteristic = mCustomService.getCharacteristic(UUID.fromString("DE49E140-17B4-4D46-AD7A-F57A22673A17"));
//        BluetoothGattCharacteristic mReadCharacteristic = mCustomService.getCharacteristic(UUID.fromString("417D2ECD-E1F5-4945-A315-C5FC949C6248"));
        if(mBluetoothGatt.readCharacteristic(mReadCharacteristic) == false){
            Log.w(TAG, "Failed to read characteristic "+mReadCharacteristic.getStringValue(0));
        }
    }

