    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.e(TAG, "onStartCommand");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());

        if (intent != null) {

            if (UPDATE_TIME == intent.getIntExtra(UPDATE_TYPE, UPDATE_WEATHER)) {
                renderTime();
                return super.onStartCommand(intent, flags, startId);
            }

            WeatherEntity weatherEntity = intent.getParcelableExtra(WEATHER_ENTITY);
            if (weatherEntity != null) {
                renderData(weatherEntity);
            } else {
                startUpdateService(this);
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

