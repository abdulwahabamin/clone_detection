    /**
     * �?�止，�?�消监�?�器
     */
    public void uninit() {
        if (mContext == null) {
            MLog.error(TAG, "mContext null when stopWatchingExternalStorage");
            return;
        }
        mContext.unregisterReceiver(mExternalStorageReceiver);
    }

