    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CONNECT_DEVICE_SECURE:
                // When DeviceListActivity returns with a device to connect

                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, true);
                }
                break;
            case REQUEST_CONNECT_DEVICE_INSECURE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, false);
                }
                break;
            case REQUEST_ENABLE_BT:
                // When the request to enable Bluetooth returns
                if (resultCode == Activity.RESULT_OK) {
                    // Bluetooth is now enabled, so set up a chat session
                    setupChat();
                } else {
                    // User did not enable Bluetooth or an error occurred
                    Log.d(TAG, "BT not enabled");
                    Toast.makeText(getActivity(), R.string.bt_not_enabled_leaving,
                            Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
                break;
            case BLE_REQUEST_CONNECT_DEVICE:
                if( resultCode == Activity.RESULT_OK) {
                    connectBleDevice(data);
                }
                break;
            case BLE_REQUEST_DEVICE_CONNECTING:
                if( resultCode == Activity.RESULT_OK){
                    bleDeviceConnecting(data);
                }
                break;
            case PICK_IMAGE:
                if( resultCode == Activity.RESULT_OK){
                    sendFile(data);
                }
        }
    }

