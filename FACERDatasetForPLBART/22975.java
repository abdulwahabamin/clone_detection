    private boolean isContainBTHeadphone(BluetoothAdapter mBluetoothAdapter) {
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        // If there are paired devices
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                if (device.getBluetoothClass().getDeviceClass() ==
                        BluetoothClass.Device.AUDIO_VIDEO_CAR_AUDIO) {
                    return true;
                } else if (device.getBluetoothClass().getDeviceClass() ==
                        BluetoothClass.Device.AUDIO_VIDEO_HANDSFREE) {
                    return true;
                } else if (device.getBluetoothClass().getDeviceClass() ==
                        BluetoothClass.Device.AUDIO_VIDEO_HEADPHONES) {
                    return true;
                } else if (device.getBluetoothClass().getDeviceClass() ==
                        BluetoothClass.Device.AUDIO_VIDEO_LOUDSPEAKER) {
                    return true;
                } else if (device.getBluetoothClass().getDeviceClass() ==
                        BluetoothClass.Device.AUDIO_VIDEO_WEARABLE_HEADSET) {
                    return true;
                }
            }
        }
        return false;
    }

