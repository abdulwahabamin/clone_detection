    @Override
    public void onStart() {
        super.onStart();
        bluetoothAdapter.enable();
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
            chatController = new info.devexchanges.bluetoothchatapp.ChatController(this, handler);
        } else {
            chatController = new info.devexchanges.bluetoothchatapp.ChatController(this, handler);
        }
    }

