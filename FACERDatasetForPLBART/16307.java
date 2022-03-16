    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isHidden()) broadcastManager.unregisterReceiver(receiver);
        else register();
    }

