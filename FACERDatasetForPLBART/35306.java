    @Override
    public void onCreate() {

        // 创建并开�?�线程UpdateThread
        mUpdateThread = new UpdateThread();
        mUpdateThread.start();
        mContext = this.getApplicationContext();
        super.onCreate();
    }

