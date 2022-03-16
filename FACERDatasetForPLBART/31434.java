    @Override
    public void onDestroy() {
        LogUtil.e(TAG, "onDestroy");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());
        super.onDestroy();
        mUseCase.unsubscribe();
        mUseCase.clear();

        System.exit(0);
    }

