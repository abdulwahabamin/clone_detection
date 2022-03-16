    @Override
    public void onDestroy() {
        super.onDestroy();
        if (chatController != null)
            chatController.stop();
        unregisterReceiver(mReceiver);
    }

