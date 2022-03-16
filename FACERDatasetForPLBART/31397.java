    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.e(TAG, "onReceive");
        //LogUtil.e(TAG, "pid=" + Process.myPid());
        //LogUtil.e(TAG, "uid=" + Process.myUid());
        mContext = context;
        super.onReceive(context, intent);

        if (intent != null && intent.getAction().equalsIgnoreCase(UPDATE_WIDGET_ACTION)) {

            if (UPDATE_TIME == intent.getIntExtra(UPDATE_TYPE, UPDATE_WEATHER)) {
                renderTime();
                return;
            }

            WeatherEntity weatherEntity = null;
            weatherEntity = intent.getParcelableExtra(WEATHER_ENTITY);
            if (weatherEntity != null)
                renderData(weatherEntity);
        }
    }

