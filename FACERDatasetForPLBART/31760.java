    protected void initializeWeatherForecastReceiver(final String actionResult) {
        mWeatherUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                appendLog(context, TAG, "BroadcastReceiver:", intent);
                if ((mGetWeatherProgress != null) && (mHandler != null)) {
                    mHandler.post(new Runnable() {
                        public void run() {
                            if (mGetWeatherProgress != null) {
                                mGetWeatherProgress.dismiss();
                            }
                        }
                    });
                }
                switch (intent.getStringExtra(actionResult)) {
                    case ForecastWeatherService.ACTION_WEATHER_UPDATE_OK:
                        updateUI();
                        break;
                    case ForecastWeatherService.ACTION_WEATHER_UPDATE_FAIL:
                        Toast.makeText(ForecastingActivity.this,
                                getString(R.string.toast_parse_error),
                                Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

