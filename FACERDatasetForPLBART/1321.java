        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice classicBtDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (mRfcommSocketAddress.compareTo(classicBtDevice.getAddress()) == 0) {
                    try {
                        mSocket = classicBtDevice.createInsecureRfcommSocketToServiceRecord(MY_UUID_INSECURE);
                        mSocket.connect();
                        mBleChatEvents.onRfcommConnect();
                    } catch (IOException e) {
                        try {
                            mSocket.close();
                        } catch (IOException e2) {
                            mBleChatEvents.onConnectionError(e2.toString());
                        }
                        mBleChatEvents.onConnectionError(e.toString());
                    }
                }
                // When discovery is finished, change the Activity title
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {

            }
        }

