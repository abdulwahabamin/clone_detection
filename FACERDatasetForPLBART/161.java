    private void connectToDevice(String deviceAddress) {
        bluetoothAdapter.cancelDiscovery();
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(deviceAddress);
        if(device!=null)
            chatController.connect(device);
        else
            Toast.makeText(MainActivity.this, "Please make sure the other phone has the app open and try again.", Toast.LENGTH_LONG).show();

    }

