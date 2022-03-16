    @Override
    protected void onResume() {
        super.onResume();
        if (mBluetoothChatHelper != null) {
            // Only if the state is STATE_NONE, do we know that we haven't
            // started already
            if (mBluetoothChatHelper.getState() == State.STATE_NONE) {
                // Start the Bluetooth chat services
                mBluetoothChatHelper.start(false);
            }
        }
    }

