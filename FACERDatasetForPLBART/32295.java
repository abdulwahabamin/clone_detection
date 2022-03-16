    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        appendLog(context, TAG, "Receiver started with intent: " + intent + " and action " + action);
        this.context = context;
        BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        appendLog(context, TAG, "onReceive:bluetoothDevice: " + bluetoothDevice);
        if (bluetoothDevice == null) {
            return;
        }
        switch (action) {
            case BluetoothDevice.ACTION_ACL_CONNECTED:
                btDeviceConnected(bluetoothDevice); break;
            case BluetoothDevice.ACTION_ACL_DISCONNECTED:
            case BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED:
                btDeviceDisConnected(bluetoothDevice); break;
        }
    }

