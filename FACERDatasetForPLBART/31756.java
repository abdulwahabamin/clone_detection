    @Override
    protected void onPause() {
        super.onPause();
        if (mGetWeatherProgress != null) {
            mGetWeatherProgress.dismiss();
        }
        unregisterReceiver(mWeatherUpdateReceiver);
    }

