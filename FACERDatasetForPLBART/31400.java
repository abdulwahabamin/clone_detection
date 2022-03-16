    @Override
    public void onDisabled(Context context) {
        LogUtil.e(TAG, "onDisabled");
        setUpdateTimeAlarm(context, false, 0);
        mDataDate = null;
        super.onDisabled(context);
        if (mPresenter != null) {
            mPresenter.stop();
            mPresenter.destroy();
        }
    }

