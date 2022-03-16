    /**
     * Indicate that the connection attempt failed and notify the UI Activity.
     */
    private void connectionFailed() {
        // Send a failure message back to the Activity
        Message msg = mHandler.obtainMessage(LanylActivity.MESSAGE_TOAST);
        Bundle bundle = new Bundle();
        bundle.putString(LanylActivity.TOAST, "�?能连接到设备�?");
        msg.setData(bundle);
        mHandler.sendMessage(msg);

        // Start the service over to restart listening mode
        LanylService.this.start();
    }

