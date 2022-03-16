    @Override
    public void onDestroy() {
        LogUtil.e(TAG, "onDestroy");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());
        super.onDestroy();

        setUpdateTimeAlarm(this, false, 0);
        mDataDate = null;
        mEntity = null;

        if (mPresenter != null) {
            mPresenter.stop();
            mPresenter.destroy();
        }
    }

