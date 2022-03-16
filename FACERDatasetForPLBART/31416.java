    @Override
    public void onCreate() {
        LogUtil.e(TAG, "onCreate");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());
        super.onCreate();
        mContext = this;
        updateTimeSequence();
    }

