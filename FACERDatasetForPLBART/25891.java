    /**
     * 注册外部存储监�?�器
     */
    private void startWatchingExternalStorage() {
        if (mContext == null) {
            MLog.error(TAG, "mContext null when startWatchingExternalStorage");
            return;
        }
        mExternalStorageReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            MLog.info(TAG, "Storage: " + intent.getData());
            updateExternalStorageState();
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        filter.addAction(Intent.ACTION_MEDIA_REMOVED);
        filter.addAction(Intent.ACTION_MEDIA_EJECT);
        filter.addDataScheme("file");
        mContext.registerReceiver(mExternalStorageReceiver, filter);
        updateExternalStorageState();
    }

