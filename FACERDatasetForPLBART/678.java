    @Override
    public void onReceive(Context context, Intent intent) {
        if (scanCallback == null) {
            return;
        }
        if(intent.getAction().equals(BluetoothDevice.ACTION_FOUND)){
            //æ‰«æ??åˆ°è“?ç‰™è®¾å¤‡
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (bluetoothDevice == null) {
                return;
            }
            if (!mDeviceMap.containsKey(bluetoothDevice.getAddress())) {
                mDeviceMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
            }
            scanCallback.discoverDevice(bluetoothDevice);
        }else if(intent.getAction().equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
            //æ‰«æ??è®¾å¤‡ç»“æ?Ÿ
            final List<BluetoothDevice> deviceList = new ArrayList<>(mDeviceMap.values());
            if(deviceList != null && deviceList.size() > 0){
                scanCallback.scanFinish(deviceList);
            } else{
                scanCallback.scanTimeout();
            }
        }
    }

