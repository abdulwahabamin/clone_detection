    @Override
    protected void onStop() {
        unregisterReceiver(mStatusListener);

        super.onStop();
    }

