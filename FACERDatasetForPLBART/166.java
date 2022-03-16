    @Override
    public void onResume() {
        super.onResume();
        if(bluetoothAdapter.isEnabled()==false)
            bluetoothAdapter.enable();
        if (chatController != null) {
            //    if (chatController.getState() == ChatController.STATE_NONE) {
            chatController = new info.devexchanges.bluetoothchatapp.ChatController(this, handler);
            chatController.start();
            //     }
        }
    }

