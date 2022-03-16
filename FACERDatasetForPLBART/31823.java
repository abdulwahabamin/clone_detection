    @Override
    protected void onPause() {
        super.onPause();
        unbindCurrentWeatherService();
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mAppBarLayout.removeOnOffsetChangedListener(this);
        unregisterReceiver(mWeatherUpdateReceiver);
    }

