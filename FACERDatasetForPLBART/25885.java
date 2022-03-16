    /**
     * �?始化，开始监�?�外部存储的状�?
     */
    public void init(Context context) {
        mContext = context;
        updateExternalStorageState();
        startWatchingExternalStorage();
    }

