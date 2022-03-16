    private void startUpdateService(Context context) {
        LogUtil.e(TAG, "startUpdateService");

        Intent intent = new Intent(context, AlarmReceiver.class);
        context.sendBroadcast(intent, Constants.RECV_WEATHER_UPDATE);
    }

