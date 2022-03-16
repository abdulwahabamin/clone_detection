    private void setupChat() {
        Log.d(Constants.TAG, "setupChat()");

        // Initialize the BluetoothChatService to perform bluetooth connections
        BluetoothChatService.setup(this, mHandler);
        //mChatService = new BluetoothChatService(this, mHandler);
    }

