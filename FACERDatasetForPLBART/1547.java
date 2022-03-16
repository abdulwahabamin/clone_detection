    public void pairDevice() {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        Log.e(TAG, "pair device about to start" + pairedDevices.size());
        if (pairedDevices.size() > 0) {
            Object[] devices = pairedDevices.toArray();
            BluetoothDevice device = (BluetoothDevice) devices[0];
            ParcelUuid[] uuid = device.getUuids();
            Log.e(TAG, "pair device " + device);
            Log.e(TAG, "pair device reached " + uuid);

            ConnectThread connect = new ConnectThread(device, MY_UUID);
            connect.start();
        }


    }

