    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String action = intent.getAction();
        int bluetoothState = extras.getInt(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
        if (action.equals(BluetoothDevice.ACTION_FOUND)){
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String deviceName = device.getName();
            String deviceHardwareAddress = device.getAddress();
            Log.i(TAG, "na him be this" + deviceName + deviceHardwareAddress);

        }
        if (action.equals(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED)){
            switch (bluetoothState){
                case BluetoothAdapter.SCAN_MODE_CONNECTABLE :
                    toastMessage = "phone discoverable and connectable";
                    break;
                case BluetoothAdapter.STATE_CONNECTED :
                        toastMessage = "phone connected";
                        break;
                case BluetoothAdapter.STATE_CONNECTING :
                      toastMessage = "phone conecting";
                      break;

                case BluetoothAdapter.STATE_DISCONNECTED :
                    toastMessage = "phone disconnected";
                    break;
                case BluetoothAdapter.STATE_DISCONNECTING :
                    toastMessage = "phone disconnecting";
                    break;


            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();


        }


    }

