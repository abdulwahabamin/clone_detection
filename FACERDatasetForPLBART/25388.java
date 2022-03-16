    protected void onStop() {
        if (client != null && client.isConnected()) {
            client.disconnect();
        }

        LocalBroadcastManager.getInstance(this).unregisterReceiver(messageReceiver);

        super.onStop();
    }

