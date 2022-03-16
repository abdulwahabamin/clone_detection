    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateThread);
        broadcastManager.unregisterReceiver(receiver);
        handler = null;
        unbinder.unbind();
    }

