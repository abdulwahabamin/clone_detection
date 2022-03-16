    @Override
    public void onReceive(Context context, Intent intent) {
        if (scanCallback == null) {
            return;
        }
        if(intent.getAction().equals(BluetoothDevice.ACTION_FOUND)){
            //扫�??到�?牙设备
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (bluetoothDevice == null) {
                return;
            }
            if (!mDeviceMap.containsKey(bluetoothDevice.getAddress())) {
                mDeviceMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
            }
            scanCallback.discoverDevice(bluetoothDevice);
        }else if(intent.getAction().equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
            //扫�??设备结�?�
            final List<BluetoothDevice> deviceList = new ArrayList<>(mDeviceMap.values());
            if(deviceList != null && deviceList.size() > 0){
                scanCallback.scanFinish(deviceList);
            } else{
                scanCallback.scanTimeout();
            }
        }
    }

