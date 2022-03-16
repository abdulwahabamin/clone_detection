    @Override
    public void onDestroy() {
        server.close();
        handler.closeAllHandlers();
        binder = null;
        stopForeground(false);
        unregisterReceiver(p2pBroadcastReceiver);
    }

