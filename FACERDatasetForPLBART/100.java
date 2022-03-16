    /**
     * Indicate that the connection was lost and notify the UI Activity.
     */
    private void connectionLost() {
        // Send a failure message back to the Activity
        Message msg = mHandler.obtainMessage(LanylActivity.MESSAGE_TOAST);
        Bundle bundle = new Bundle();
        bundle.putString(LanylActivity.TOAST, "设备已�?断开连接�?");
        msg.setData(bundle);
        mHandler.sendMessage(msg);

        // Start the service over to restart listening mode
        LanylService.this.start();
    }

