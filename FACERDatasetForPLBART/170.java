    @Override
    public void onPause() {
        super.onPause();
        if (chatController != null)
            chatController.stop();
        if(bluetoothAdapter.isEnabled())
            bluetoothAdapter.disable();
    }

