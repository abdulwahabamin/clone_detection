    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler = null;
        broadcastManager.unregisterReceiver(receiver);
        unbinder.unbind();
    }

