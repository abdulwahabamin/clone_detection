    private void doBluetoothDeviceTransfer(Uri uri) {
        if (SystemProperties.getBoolean("ro.qualcomm.proprietary_obex", false)) {
            if (mBluetooth != null) {
                if (mBluetooth.isEnabled()) {
                    Intent intent = new Intent(ACTION_PUSH_FILE);
                    intent.setData(uri);
                    intent.putExtra(PROFILE, PROFILE_OPP);
                    intent.setClassName ("com.quicinc.bluetooth", "com.quicinc.bluetooth.BluetoothDevicePicker");
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e(TAG, "No Activity for : " + ACTION_PUSH_FILE, e);
                    }
                }
            }
        }
    }

