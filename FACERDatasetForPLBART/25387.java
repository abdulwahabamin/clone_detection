    @Override
    protected void onStart() {
        super.onStart();
        client.connect();
        IntentFilter messageFilter = new IntentFilter(Intent.ACTION_SEND);
        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, messageFilter);
    }

