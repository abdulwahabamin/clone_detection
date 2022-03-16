    @Override
    public void onDestroy() {
        super.onDestroy();
        if (receiversRegistered) {
            unregisterReceiver(mReceiver);
            unregisterListener();
        }
        stopForeground(true);
    }

