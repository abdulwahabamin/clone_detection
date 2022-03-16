    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) broadcastManager.unregisterReceiver(receiver);
        else register();
    }

