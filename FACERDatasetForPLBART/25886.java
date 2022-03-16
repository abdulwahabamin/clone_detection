    /**
     * å?œæ­¢ï¼Œå?–æ¶ˆç›‘å?¬å™¨
     */
    public void uninit() {
        if (mContext == null) {
            MLog.error(TAG, "mContext null when stopWatchingExternalStorage");
            return;
        }
        mContext.unregisterReceiver(mExternalStorageReceiver);
    }

