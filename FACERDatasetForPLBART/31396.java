    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.e(TAG, "onReceive");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());

        Intent i = new Intent(context, WeatherUpdateService.class);
        context.startService(i);
    }

