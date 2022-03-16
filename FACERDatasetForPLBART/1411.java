    /**
     * [Central device role]
     *
     * Connect to a Peripheral device
     * @param data
     */
    private void connectBleDevice(Intent data){
        mBleMode = BLEMode.CENTRAL;
        if(mChatService != null)
            mChatService.stop();
        mConnectedDeviceName = data.getExtras().getString(BLEDiscoveringActivity.EXTRA_DEVICE_NAME);
        String address = data.getExtras().getString(BLEDiscoveringActivity.EXTRA_DEVICE_ADDRESS);
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        showStatus(BluetoothChatService.STATE_CONNECTING);
        BLECentralHelper.getInstance().connect(this.getContext(), device, mBLEChatEvents);
    }

