    @Override
    public void onEnabled(Context context) {
        LogUtil.e(TAG, "onEnabled");
        updateTimeSequence();
        super.onEnabled(context);
    }

