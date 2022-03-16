    /**
     * [Peripheral device role]
     *
     * A Central device is connecting to us
     * @param data
     */
    private void bleDeviceConnecting(Intent data){
        mBleMode = BLEMode.PERIPHERAL;
        if(mChatService != null)
            mChatService.stop();
        //showConnectedName(data.getExtras().getString(BLEAdvertisingActivity.EXTRA_CLIENT_NAME));
        showStatus(BluetoothChatService.STATE_CONNECTED);
        BLEPeripheralHelper.getInstance().register(mBlePeripheralChatEvents);
    }

